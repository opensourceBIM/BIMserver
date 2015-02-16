package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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