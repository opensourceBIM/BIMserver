package org.bimserver.geometry;

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