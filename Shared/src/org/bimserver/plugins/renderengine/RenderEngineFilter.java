package org.bimserver.plugins.renderengine;

public class RenderEngineFilter {
	private boolean transformGeometry = false;

	public RenderEngineFilter() {
	}
	
	public RenderEngineFilter(boolean transformGeometry) {
		this.transformGeometry = transformGeometry;
	}
	
	public void setTranslateGeometry(boolean transformGeometry) {
		this.transformGeometry = transformGeometry;
	}
	
	public boolean isTranslateGeometry() {
		return transformGeometry;
	}
}