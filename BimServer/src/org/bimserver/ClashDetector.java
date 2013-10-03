package org.bimserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineInstanceVisualisationProperties;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.openmali.vecmath2.Point3f;
import org.openmali.vecmath2.Vector3f;

public class ClashDetector {
	
	public static final float SMALL_NUM = 0.00000001f;
	private static class BoundingBox {

		private double[] min;
		private double[] max;

		public BoundingBox(double[] min, double[] max) {
			this.min = min;
			this.max = max;
		}

		public boolean collidesWith(BoundingBox other) {
			for (int i=0; i<3; i++) {
				if (max[i] < other.min[i] || min[i] > other.max[i]) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public String toString() {
			return min[0] + ", " + min[1] + ", " + min[2] + " - " + max[0] + ", " + max[1] + ", " + max[2];
		}
	}
	
	private final Map<IfcProduct, BoundingBox> boundingBoxes = new HashMap<IfcProduct, ClashDetector.BoundingBox>();
	
	public void detect(IfcModelInterface model, RenderEngineModel renderEngineModel) throws RenderEngineException {
		RenderEngineGeometry geometry = renderEngineModel.finalizeModelling(renderEngineModel.initializeModelling());
		for (IfcProduct product : model.getAllWithSubTypes(IfcProduct.class)) {
			RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(product.getExpressId());
			RenderEngineInstanceVisualisationProperties visualisationProperties = renderEngineInstance.getVisualisationProperties();

			double min[] = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
			double max[] = new double[]{-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};
			
			for (int i=visualisationProperties.getStartIndex(); i<visualisationProperties.getStartIndex() + visualisationProperties.getPrimitiveCount() * 3; i++) {
				int index = geometry.getIndex(i);
				for (int k=0; k<3; k++) {
					double value = geometry.getVertex(index + k);
					if (value < min[k]) {
						min[k] = value;
					}
					if (value > max[k]) {
						max[k] = value;
					}
				}
			}
			
			BoundingBox bb = new BoundingBox(min, max);
			boundingBoxes.put(product, bb);
		}
		
		for (java.util.Map.Entry<IfcProduct, BoundingBox> boundingBox1 : boundingBoxes.entrySet()) {
			for (java.util.Map.Entry<IfcProduct, BoundingBox> boundingBox2 : boundingBoxes.entrySet()) {
				if (boundingBox1 == boundingBox2) {
					continue;
				}
				if (test(renderEngineModel, geometry, boundingBox1, boundingBox2)) {
					System.out.println("hit " + boundingBox1.getKey() + " / " + boundingBox2.getKey());
				}
			}
		}
		System.out.println(boundingBoxes.size() * boundingBoxes.size());
	}

	private boolean test(RenderEngineModel renderEngineModel,
			RenderEngineGeometry geometry, java.util.Map.Entry<IfcProduct, BoundingBox> boundingBox1,
			java.util.Map.Entry<IfcProduct, BoundingBox> boundingBox2)
			throws RenderEngineException {
		if (boundingBox1.getValue().collidesWith(boundingBox2.getValue())) {
			RenderEngineInstanceVisualisationProperties visualisationProperties1 = renderEngineModel.getInstanceFromExpressId(boundingBox1.getKey().getExpressId()).getVisualisationProperties();
			RenderEngineInstanceVisualisationProperties visualisationProperties2 = renderEngineModel.getInstanceFromExpressId(boundingBox2.getKey().getExpressId()).getVisualisationProperties();
			
			List<Triangle> triangles1 = getTrianglesx(geometry, visualisationProperties1);					
			List<Triangle> triangles2 = getTrianglesx(geometry, visualisationProperties2);
			
			for (Triangle triangle1 : triangles1) {
				for (Triangle triangle2 : triangles2) {
					if (testTriangle(triangle1, triangle2)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ClashDetector clashDetector = new ClashDetector();
		System.out.println(clashDetector.testTriangle(new Triangle(new Point3f(0f, 0f, 0f), new Point3f(1f, 0f, 0f), new Point3f(0f, 1f, 0f)), new Triangle(new Point3f(0f, 0f, 1f), new Point3f(1f, 0f, 1f), new Point3f(0f, 1f, 1f))));
		System.out.println(clashDetector.testTriangle(new Triangle(new Point3f(0f, 0f, 0f), new Point3f(1f, 0f, 0f), new Point3f(0f, 1f, 0f)), new Triangle(new Point3f(0f, 0f, 1f), new Point3f(1f, 0f, 1f), new Point3f(0f, 1f, 1f))));
	}
	
	private boolean testTriangle(Triangle triangle1, Triangle triangle2) {
		if (intersectRayTriangle(new Ray(triangle1.getPointOne(), new Vector3f(triangle1.getPointTwo().sub(triangle1.getPointOne()))), triangle2) != null) {
			return true;
		}
		if (intersectRayTriangle(new Ray(triangle1.getPointTwo(), new Vector3f(triangle1.getPointThree().sub(triangle1.getPointTwo()))), triangle2) != null) {
			return true;
		}
		if (intersectRayTriangle(new Ray(triangle1.getPointThree(), new Vector3f(triangle1.getPointOne().sub(triangle1.getPointThree()))), triangle2) != null) {
			return true;
		}
		return false;
	}

	private List<Triangle> getTrianglesx(RenderEngineGeometry geometry,
			RenderEngineInstanceVisualisationProperties visualisationProperties1) {
		List<Triangle> triangles = new ArrayList<Triangle>();
		for (int i=visualisationProperties1.getStartIndex(); i<visualisationProperties1.getStartIndex() + visualisationProperties1.getPrimitiveCount() * 3; i+=3) {
			int index0 = geometry.getIndex(i);
			int index1 = geometry.getIndex(i + 1);
			int index2 = geometry.getIndex(i + 2);
			Triangle triangle1 = new Triangle(
					new Point3f(geometry.getVertex(index0), geometry.getVertex(index0 + 1), geometry.getVertex(index0 + 2)), 
					new Point3f(geometry.getVertex(index1), geometry.getVertex(index1 + 1), geometry.getVertex(index1 + 2)), 
					new Point3f(geometry.getVertex(index2), geometry.getVertex(index2 + 1), geometry.getVertex(index2 + 2)));
			triangles.add(triangle1);
		}
		return triangles;
	}
	
	 static class Triangle {
	        
	        Point3f[] points = new Point3f[3];
	        
	        public Triangle(Point3f point1, Point3f point2, Point3f point3) {
	            points[0] = point1;
	            points[1] = point2;
	            points[2] = point3;
	        }
	        
	        public Point3f getPointOne() {
	            return points[0];
	        }
	        
	        public Point3f getPointTwo() {
	            return points[1];
	        }
	        
	        public Point3f getPointThree() {
	            return points[2];
	        }
	        
	        public Point3f intersects(Point3f from, Vector3f dir) {
	            Ray ray = new Ray(from, dir);
	            return intersectRayTriangle(ray, this);
	        }
	        
	    }
	    
	    static class Ray {
	        
	        Point3f from = null;
	      Vector3f dir = null;
	        
	        public Ray(Point3f from, Vector3f dir) {
	            this.from = from;
	            this.dir = dir;
	        }
	        
	        public Point3f getStart() {
	            return from;
	        }
	        
	        public Vector3f getDirection() {
	            return dir;
	        }
	        
	    }
	    
	public static Point3f intersectRayTriangle(Ray R, Triangle T) {
        Point3f I = new Point3f();
        Vector3f    u, v, n;
        Vector3f    dir, w0, w;
        float     r, a, b;
        
        u = new Vector3f(T.getPointTwo());
        u.sub(T.getPointOne());
        v = new Vector3f(T.getPointThree());
        v.sub(T.getPointOne());
        n = new Vector3f(); // cross product
        n.cross(u, v);
        
        if (n.length() == 0) {
            return null;
        }
        
        dir = new Vector3f(R.getDirection());
        w0 = new Vector3f(R.getStart());
        w0.sub(T.getPointOne());
        a = -(new Vector3f(n).dot(w0));
        b = new Vector3f(n).dot(dir);
        
        if ((float)Math.abs(b) < SMALL_NUM) {
            return null;
        }
        
        r = a / b;
        if (r < 0.0) {
            return null;
        }
        
        I = new Point3f(R.getStart());
        I.addX(r * dir.getX());
        I.addY(r * dir.getY());
        I.addZ(r * dir.getZ());
        
        return I;
    }
}