package org.bimserver.geometry;

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

public class Vector3 {

	public static float[] normalize(float[] out, float[] a) {
		float x = a[0];
		float y = a[1];
		float z = a[2];
		float len = x*x + y*y + z*z;
		  if (len > 0) {
		    //TODO: evaluate use of glm_invsqrt here?
		    len = (float) (1 / Math.sqrt(len));
		  }
		  out[0] = a[0] * len;
		  out[1] = a[1] * len;
		  out[2] = a[2] * len;
		  return out;
	}
}
