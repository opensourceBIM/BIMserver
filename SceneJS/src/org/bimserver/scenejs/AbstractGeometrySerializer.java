package org.bimserver.scenejs;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.common.util.EList;

public abstract class AbstractGeometrySerializer extends EmfSerializer {
	private Extends sceneExtends = new Extends();
	private HashMap<String, Extends> geometryExtents = new HashMap<String, Extends>();
	
	protected void calculateGeometryExtents() throws IfcEngineException, SerializerException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			calculateExtents(ifcProduct.getGlobalId().getWrappedValue(), ifcProduct);
		}
	}
	
	public Extends getSceneExtends() {
		return sceneExtends;
	}
	
	private void calculateExtents(String id, IfcProduct ifcObject) throws IfcEngineException, SerializerException {
		// Get the extents object related to this geometric object 
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extends());
		}
		Extends extents = geometryExtents.get(id);

		if (ifcObject.getGeometryInstance() == null) {
			EList<Float> vertices = getModel().getGeometry().getVertices();
			for (int i = 0; i < vertices.size(); i += 3) {
				extents.addToMinExtents(new float[] { vertices.get(i + 0), vertices.get(i + 1), vertices.get(i + 2) });
				extents.addToMaxExtents(new float[] { vertices.get(i + 0), vertices.get(i + 1), vertices.get(i + 2) });
			}
		} else {
			extents.integrate(ifcObject.getBounds());
		}
		sceneExtends.addToMinExtents(extents.min);
		sceneExtends.addToMaxExtents(extents.max);
	}
}