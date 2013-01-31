package org.bimserver.plugins.serializers;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.Bounds;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.ifcengine.IfcEngineException;

public abstract class AbstractGeometrySerializer extends EmfSerializer {
	private Extends sceneExtends = new Extends();
	private HashMap<String, Extends> geometryExtents = new HashMap<String, Extends>();
	
	protected void calculateGeometryExtents() throws IfcEngineException, SerializerException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			calculateExtents(ifcProduct.getGlobalId(), ifcProduct);
		}
	}
	
	public Extends getSceneExtends() {
		return sceneExtends;
	}
	
	private void calculateExtents(String id, IfcProduct ifcObject) throws IfcEngineException, SerializerException {
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extends());
		}
		Extends extents = geometryExtents.get(id);

		Bounds bounds = ifcObject.getBounds();
		if (bounds != null) {
			extents.integrate(bounds);
		}
		sceneExtends.addToMinExtents(extents.min);
		sceneExtends.addToMaxExtents(extents.max);
	}
}