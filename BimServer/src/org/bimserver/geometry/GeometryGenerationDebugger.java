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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.HashMapVirtualObject;

public class GeometryGenerationDebugger {

	private final Map<String, Map<Long, TransformedVertexNotMatching>> map = new HashMap<>();
	
	public void transformedVertexNotMatching(HashMapVirtualObject ifcProduct, float[] transformedOriginal, float[] transformedNew, double[] productTranformationMatrix, double[] totalTranformationMatrix) {
		Map<Long, TransformedVertexNotMatching> map2 = map.get(ifcProduct.eClass().getName());
		if (map2 == null) {
			map2 = new HashMap<>();
			map.put(ifcProduct.eClass().getName(), map2);
		}
		TransformedVertexNotMatching transformedVertexNotMatching = map2.get(ifcProduct.getOid());
		if (transformedVertexNotMatching == null) {
			transformedVertexNotMatching = new TransformedVertexNotMatching();
			map2.put(ifcProduct.getOid(), transformedVertexNotMatching);
		}
		transformedVertexNotMatching.add(transformedOriginal, transformedNew, productTranformationMatrix, totalTranformationMatrix);
	}
	
	public String dump() {
		StringBuilder sb = new StringBuilder();
		if (map.isEmpty()) {
			return null;
		}
		for (String type : map.keySet()) {
			sb.append(type + "\n");
			Map<Long, TransformedVertexNotMatching> map2 = map.get(type);
			for (long oid : map2.keySet()) {
				TransformedVertexNotMatching transformedVertexNotMatching = map2.get(oid);
				sb.append(oid + ": " + transformedVertexNotMatching.size() + ": " + transformedVertexNotMatching.getBiggestMismatch() + "\n");
			}
		}
		return sb.toString();
	}
}