package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
public enum SSIPrefix {
	meter(0),
	attometer(-18),
	femtometer(-15),
	picometer(-12),
	nanometer(-9),
	micrometer(-6),
	millimeter(-3),
	centimeter(-2),
	decimeter(-1),
	decameter(1),
	hectometer(2),
	kilometer(3),
	megameter(6),
	gigameter(9),
	terameter(12),
	petameter(15),
	exameter(18);
	int ordinal;

	SSIPrefix(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}