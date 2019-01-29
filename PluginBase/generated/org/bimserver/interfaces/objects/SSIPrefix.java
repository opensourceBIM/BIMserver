package org.bimserver.interfaces.objects;

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