package org.bimserver.utils;

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

import org.bimserver.models.geometry.Bounds;

public class IfcTools3d {
	public static float getVolume(Bounds bounds) {
		return (float) ((bounds.getMax().getX() - bounds.getMin().getX()) * (bounds.getMax().getY() - bounds.getMin().getY()) * (bounds.getMax().getZ() * bounds.getMin().getZ()));
	}

	public static float getArea(Bounds bounds) {
		return (float) ((bounds.getMax().getX() - bounds.getMin().getX()) * (bounds.getMax().getY() - bounds.getMin().getY()));
	}
}
