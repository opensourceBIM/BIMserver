package org.bimserver.plugins.renderengine;

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

public class RenderEngineSettings {
	private IndexFormat indexFormat = IndexFormat.AUTO_DETECT;
	private Precision precision = Precision.SINGLE;
	private boolean generateTriangles = true;
	private boolean generateNormals = true;
	private boolean generateWireFrame;

	public IndexFormat getIndexFormat() {
		return indexFormat;
	}

	public void setIndexFormat(IndexFormat indexFormat) {
		this.indexFormat = indexFormat;
	}

	public Precision getPrecision() {
		return precision;
	}

	public void setPrecision(Precision precision) {
		this.precision = precision;
	}

	public boolean isGenerateTriangles() {
		return generateTriangles;
	}

	public void setGenerateTriangles(boolean generateTriangles) {
		this.generateTriangles = generateTriangles;
	}

	public boolean isGenerateNormals() {
		return generateNormals;
	}

	public void setGenerateNormals(boolean generateNormals) {
		this.generateNormals = generateNormals;
	}

	public boolean isGenerateWireFrame() {
		return generateWireFrame;
	}

	public void setGenerateWireFrame(boolean generateWireFrame) {
		this.generateWireFrame = generateWireFrame;
	}
}
