package org.bimserver.plugins.renderengine;

public class RenderEngineFilter {
	private boolean translateGeometry = false;

	public RenderEngineFilter() {
	}
	
	public RenderEngineFilter(boolean translateGeometry) {
		this.translateGeometry = translateGeometry;
	}
	
	public void setTranslateGeometry(boolean translateGeometry) {
		this.translateGeometry = translateGeometry;
	}
	
	public boolean isTranslateGeometry() {
		return translateGeometry;
	}
}