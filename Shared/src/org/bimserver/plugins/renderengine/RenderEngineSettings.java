package org.bimserver.plugins.renderengine;

public class RenderEngineSettings {
	private IndexFormat indexFormat;
	private Precision precision;
	private boolean generateTriangles;
	private boolean generateNormals;
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
