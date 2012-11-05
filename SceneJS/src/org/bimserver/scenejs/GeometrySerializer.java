package org.bimserver.scenejs;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;

public abstract class GeometrySerializer extends EmfSerializer {
	private Extends sceneExtends = new Extends();
	private IfcEngine ifcEngine;
	private IfcEngineGeometry geometry;
	private HashMap<String, Extends> geometryExtents = new HashMap<String, Extends>();
	private IfcEngineModel ifcEngineModel;

	protected IfcEngineGeometry getGeometry() {
		if (geometry == null) {
			try {
				ifcEngine.init();
				Serializer serializer = getPluginManager().requireIfcStepSerializer();
				serializer.init(model, getProjectInfo(), getPluginManager(), ifcEngine, false);
				ifcEngineModel = ifcEngine.openModel(serializer.getBytes());
				ifcEngineModel.setPostProcessing(true);
				geometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
			} catch (IfcEngineException e) {
				e.printStackTrace();
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		}
		return geometry;
	}
	
	protected int getNrIndices() {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getIndices().size();
		} else {
			return getGeometry().getNrIndices();
		}
	}
	
	protected int getNrVertices() {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getVertices().size();
		} else {
			return getGeometry().getNrVertices();
		}
	}
	
	protected float getVertex(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getVertices().get(index);
		} else {
			return getGeometry().getVertex(index);
		}
	}
	
	protected float getNormal(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getNormals().get(index);
		} else {
			return getGeometry().getNormal(index);
		}
	}
	
	protected int getIndex(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getIndices().get(index);
		} else {
			return getGeometry().getIndex(index);
		}
	}
	
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
			for (int i = 0; i < getNrVertices(); i += 3) {
				extents.addToMinExtents(new float[] { getVertex(i + 0), getVertex(i + 1), getVertex(i + 2) });
				extents.addToMaxExtents(new float[] { getVertex(i + 0), getVertex(i + 1), getVertex(i + 2) });
			}
		} else {
			extents.integrate(ifcObject.getBounds());
		}
		sceneExtends.addToMinExtents(extents.min);
		sceneExtends.addToMaxExtents(extents.max);
	}
}