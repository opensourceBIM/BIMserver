package org.bimserver;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.eclipse.emf.ecore.EClass;

public class GeometrySimplifier {

	private final Map<EClass, Map<Integer, Set<GeometryData>>> data = new HashMap<EClass, Map<Integer, Set<GeometryData>>>();

	public void add(IfcProduct ifcProduct, GeometryData geometryData) {
		Map<Integer, Set<GeometryData>> ofType = data.get(ifcProduct.eClass());
		if (ofType == null) {
			ofType = new HashMap<>();
			data.put(ifcProduct.eClass(), ofType);
		}
		Set<GeometryData> set = ofType.get(geometryData.getVertices().length);
		if (set == null) {
			set = new HashSet<GeometryData>();
			ofType.put(geometryData.getVertices().length, set);
		}
		set.add(geometryData);
	}

	public Set<GeometryData> getMatchingGeometry(IfcProduct ifcProduct, GeometryData geometryData) {
		Set<GeometryData> result = new HashSet<>();
		Map<Integer, Set<GeometryData>> ofType = data.get(ifcProduct.eClass());
		if (ofType != null) {
			Set<GeometryData> set = ofType.get(geometryData.getVertices().length);
			if (set != null) {
				for (GeometryData d : set) {
					if (d != ifcProduct.getGeometry().getData()) {
						if (matchSameOrder(geometryData, d)) {
							result.add(d);
//					} else if (matchTotalDistance(geometryData, d)) {
//						return d;
						}
					}
				}
			}
		}
		return result;
	}
	
//	private boolean matchTotalDistance(GeometryData geometryData, GeometryData d) {
//		FloatBuffer buffer1 = ByteBuffer.wrap(geometryData.getVertices()).asFloatBuffer();
//		FloatBuffer buffer2 = ByteBuffer.wrap(d.getVertices()).asFloatBuffer();
//		float lastX1 = buffer1.get(0);
//		float lastY1 = buffer1.get(1);
//		float lastZ1 = buffer1.get(2);
//		float lastX2 = buffer2.get(0);
//		float lastY2 = buffer2.get(1);
//		float lastZ2 = buffer2.get(2);
//		double totalDistance1 = 0;
//		double totalDistance2 = 0;
//		for (int i=3; i<buffer1.capacity(); i+=3) {
//			double distance1 = Math.sqrt(Math.pow(buffer1.get(i) - lastX1, 2) + Math.pow(buffer1.get(i+1) - lastY1, 2) + Math.pow(buffer1.get(i+2) - lastZ1, 2));
//			double distance2 = Math.sqrt(Math.pow(buffer2.get(i) - lastX2, 2) + Math.pow(buffer2.get(i+1) - lastY2, 2) + Math.pow(buffer2.get(i+2) - lastZ2, 2));
//			totalDistance1 += distance1;
//			totalDistance2 += distance2;
//			lastX1 = buffer1.get(i);
//			lastY1 = buffer1.get(i+1);
//			lastZ1 = buffer1.get(i+2);
//			lastX2 = buffer2.get(i);
//			lastY2 = buffer2.get(i+1);
//			lastZ2 = buffer2.get(i+2);
//		}
//		if (Math.abs(totalDistance1 - totalDistance2) < 0.1) {
//			return true;
//		}
//		return false;
//	}

	private boolean matchSameOrder(GeometryData geometryDate, GeometryData d) {
		ByteBuffer bb1 = ByteBuffer.wrap(geometryDate.getVertices());
		bb1.order(ByteOrder.nativeOrder());
		FloatBuffer buffer1 = bb1.asFloatBuffer();
		ByteBuffer bb2 = ByteBuffer.wrap(d.getVertices());
		bb2.order(ByteOrder.nativeOrder());
		FloatBuffer buffer2 = bb2.asFloatBuffer();
		float lastX1 = buffer1.get(0);
		float lastY1 = buffer1.get(1);
		float lastZ1 = buffer1.get(2);
		float lastX2 = buffer2.get(0);
		float lastY2 = buffer2.get(1);
		float lastZ2 = buffer2.get(2);
		for (int i=3; i<buffer1.capacity(); i+=3) {
			double distance1 = Math.sqrt(Math.pow(buffer1.get(i) - lastX1, 2) + Math.pow(buffer1.get(i+1) - lastY1, 2) + Math.pow(buffer1.get(i+2) - lastZ1, 2));
			double distance2 = Math.sqrt(Math.pow(buffer2.get(i) - lastX2, 2) + Math.pow(buffer2.get(i+1) - lastY2, 2) + Math.pow(buffer2.get(i+2) - lastZ2, 2));
			double diff = distance1 - distance2;
			if (diff > 0.1 || diff < -0.1) {
				return false;
			}
			lastX1 = buffer1.get(i);
			lastY1 = buffer1.get(i+1);
			lastZ1 = buffer1.get(i+2);
			lastX2 = buffer2.get(i);
			lastY2 = buffer2.get(i+1);
			lastZ2 = buffer2.get(i+2);
		}
		return true;
	}
}