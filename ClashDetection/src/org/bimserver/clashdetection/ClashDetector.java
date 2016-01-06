package org.bimserver.clashdetection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;

public class ClashDetector {

	public static class Combination {
		private String type1;
		private String type2;

		public Combination(String type1, String type2) {
			// Make cononical
			if (type1.compareTo(type2) > 0) {
				this.type1 = type1;
				this.type2 = type2;
			} else {
				this.type1 = type2;
				this.type2 = type1;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
			result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Combination other = (Combination) obj;
			if (type1 == null) {
				if (other.type1 != null)
					return false;
			} else if (!type1.equals(other.type1))
				return false;
			if (type2 == null) {
				if (other.type2 != null)
					return false;
			} else if (!type2.equals(other.type2))
				return false;
			return true;
		}
	}
	
	private List<IfcProduct> products;
	private static final Set<Combination> combinationToIgnore = new HashSet<>();
	private static final Set<String> typesToOnlyCheckWithOwnType = new HashSet<>();
	private float epsilon;

	static {
		typesToOnlyCheckWithOwnType.add("IfcSpace");
		typesToOnlyCheckWithOwnType.add("IfcSite");

		combinationToIgnore.add(new Combination("IfcWall", "IfcOpeningElement"));
		combinationToIgnore.add(new Combination("IfcWallStandardCase", "IfcOpeningElement"));
		combinationToIgnore.add(new Combination("IfcSlab", "IfcOpeningElement"));
		
		combinationToIgnore.add(new Combination("IfcWall", "IfcWindow"));
		combinationToIgnore.add(new Combination("IfcWallStandardCase", "IfcWindow"));
		
		combinationToIgnore.add(new Combination("IfcWall", "IfcDoor"));
		combinationToIgnore.add(new Combination("IfcWallStandardCase", "IfcDoor"));

		combinationToIgnore.add(new Combination("IfcOpeningElement", "IfcWindow"));
		combinationToIgnore.add(new Combination("IfcOpeningElement", "IfcDoor"));
	}
	
	public ClashDetector(List<IfcProduct> products, float epsilon) {
		this.products = products;
		this.epsilon = epsilon;
	}

	public List<Clash> findClashes() {
		List<Clash> clashes = new ArrayList<Clash>();
		for (int i=0; i<products.size(); i++) {
			IfcProduct ifcProduct1 = products.get(i);
			GeometryInfo geometryInfo1 = ifcProduct1.getGeometry();
			if (geometryInfo1 != null) {
				for (int j = i + 1; j<products.size(); j++) {
					IfcProduct ifcProduct2 = products.get(j);
					if (shouldCheck(ifcProduct1, ifcProduct2)) {
						GeometryInfo geometryInfo2 = ifcProduct2.getGeometry();
						if (geometryInfo2 != null) {
							if (boundingBoxesClash(geometryInfo1, geometryInfo2)) {
								if (trianglesClash(geometryInfo1, geometryInfo2)) {
									clashes.add(new Clash(ifcProduct1, ifcProduct2));
									System.out.println(ifcProduct1.eClass().getName() + " / " + ifcProduct2.eClass().getName());
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Clashes: " + clashes.size());
		return clashes;
	}

	private boolean shouldCheck(IfcProduct ifcProduct1, IfcProduct ifcProduct2) {
		String type1 = ifcProduct1.eClass().getName();
		String type2 = ifcProduct2.eClass().getName();
		if ((typesToOnlyCheckWithOwnType.contains(type1) || typesToOnlyCheckWithOwnType.contains(type2)) && !type1.equals(type2)) {
			return false;
		}
		if (combinationToIgnore.contains(new Combination(type1, type2))) {
			return false;
		}
		return true;
	}

	private boolean trianglesClash(GeometryInfo geometryInfo1, GeometryInfo geometryInfo2) {
		GeometryData data1 = geometryInfo1.getData();
		GeometryData data2 = geometryInfo2.getData();
		
		IntBuffer indices1 = getIntBuffer(data1.getIndices());
		FloatBuffer vertices1 = getFloatBuffer(data1.getVertices());

		IntBuffer indices2 = getIntBuffer(data2.getIndices());
		FloatBuffer vertices2 = getFloatBuffer(data2.getVertices());
		
		DoubleBuffer transformation1 = getDoubleBuffer(geometryInfo1.getTransformation());
		double[] transformationArray1 = new double[16];
		for (int i=0; i<16; i++) {
			transformationArray1[i] = transformation1.get();
		}
		
		DoubleBuffer transformation2 = getDoubleBuffer(geometryInfo2.getTransformation());
		double[] transformationArray2 = new double[16];
		for (int i=0; i<16; i++) {
			transformationArray2[i] = transformation2.get();
		}

		for (int i=0; i<indices1.capacity(); i+=3) {
			Triangle triangle = new Triangle(indices1, vertices1, i, transformationArray1);
			for (int j=0; j<indices2.capacity(); j+=3) {
				Triangle triangle2 = new Triangle(indices2, vertices2, j, transformationArray2);
				if (triangle.intersects(triangle2, epsilon)) {
					return true;
				}
			}
		}
		return false;
	}

	private FloatBuffer getFloatBuffer(byte[] input) {
		ByteBuffer vertexBuffer = ByteBuffer.wrap(input);
		vertexBuffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer verticesFloatBuffer = vertexBuffer.asFloatBuffer();
		verticesFloatBuffer.position(0);
		return verticesFloatBuffer;
	}

	private DoubleBuffer getDoubleBuffer(byte[] input) {
		ByteBuffer vertexBuffer = ByteBuffer.wrap(input);
		vertexBuffer.order(ByteOrder.LITTLE_ENDIAN);
		DoubleBuffer doubleBuffer = vertexBuffer.asDoubleBuffer();
		doubleBuffer.position(0);
		return doubleBuffer;
	}
	
	private IntBuffer getIntBuffer(byte[] input) {
		ByteBuffer indicesBuffer = ByteBuffer.wrap(input);
		indicesBuffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer indicesIntBuffer = indicesBuffer.asIntBuffer();
		return indicesIntBuffer;
	}

	private boolean boundingBoxesClash(GeometryInfo geometryInfo1, GeometryInfo geometryInfo2) {
		return (geometryInfo1.getMaxBounds().getX() > geometryInfo2.getMinBounds().getX() &&
				geometryInfo1.getMinBounds().getX() < geometryInfo2.getMaxBounds().getX() &&
				geometryInfo1.getMaxBounds().getY() > geometryInfo2.getMinBounds().getY() &&
				geometryInfo1.getMinBounds().getY() < geometryInfo2.getMaxBounds().getY() &&
				geometryInfo1.getMaxBounds().getZ() > geometryInfo2.getMinBounds().getZ() &&
				geometryInfo1.getMinBounds().getZ() < geometryInfo2.getMaxBounds().getZ());
	}
}