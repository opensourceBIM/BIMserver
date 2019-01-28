package org.bimserver.plugins.serializers;

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

import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.slf4j.LoggerFactory;

public abstract class AbstractGeometrySerializer extends EmfSerializer {
	private Extends sceneExtends = new Extends();
	private HashMap<String, Extends> geometryExtents = new HashMap<String, Extends>();
	
	protected void calculateGeometryExtents() throws RenderEngineException, SerializerException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			try {
				calculateExtents(ifcProduct.getGlobalId(), ifcProduct);
			} catch (Exception e) {
				LoggerFactory.getLogger(AbstractGeometrySerializer.class).error("", e);
			}
		}
	}
	
	public Extends getSceneExtends() {
		return sceneExtends;
	}
	
	private void calculateExtents(String id, IfcProduct ifcObject) throws RenderEngineException, SerializerException {
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extends());
		}
		Extends extents = geometryExtents.get(id);

		GeometryInfo geometryInfo = ifcObject.getGeometry();
		if (geometryInfo != null) {
			extents.integrate(geometryInfo);
			sceneExtends.addToMinExtents(extents.min);
			sceneExtends.addToMaxExtents(extents.max);
		}
	}
}