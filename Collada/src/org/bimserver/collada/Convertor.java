package org.bimserver.collada;

import org.bimserver.models.ifc2x3tc1.IfcRoot;

public class Convertor<T extends IfcRoot> {
	private final Class<T> cl;
	private final double[] colors;
	private final double opacity;
	
	public Convertor(Class<T> cl, double[] colors, double opacity) {
		this.cl = cl;
		this.colors = colors;
		this.opacity = opacity;
	}
	
	public Class<T> getCl() {
		return cl;
	}
	
	public String getMaterialName(Object t) {
		return cl.getSimpleName();
	}
	
	public double[] getColors() {
		return colors;
	}
	
	public double getOpacity() {
		return opacity;
	}
}