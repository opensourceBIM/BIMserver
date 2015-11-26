package org.bimserver.clashdetection;

import org.bimserver.models.ifc2x3tc1.IfcProduct;

public class Clash {

	private IfcProduct ifcProduct1;
	private IfcProduct ifcProduct2;

	public Clash(IfcProduct ifcProduct1, IfcProduct ifcProduct2) {
		this.ifcProduct1 = ifcProduct1;
		this.ifcProduct2 = ifcProduct2;
	}
	
	public IfcProduct getIfcProduct1() {
		return ifcProduct1;
	}
	
	public IfcProduct getIfcProduct2() {
		return ifcProduct2;
	}
}
