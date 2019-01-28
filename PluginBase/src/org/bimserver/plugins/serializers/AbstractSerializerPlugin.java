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

import java.util.Set;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;

public abstract class AbstractSerializerPlugin implements SerializerPlugin {
	@Override
	public ObjectDefinition getUserSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();

		ParameterDefinition extensionParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		extensionParameter.setIdentifier(EXTENSION);
		extensionParameter.setName(EXTENSION);
		extensionParameter.setDescription("Extension of the downloaded file");
		PrimitiveDefinition stringType = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringType.setType(PrimitiveEnum.STRING);
		extensionParameter.setType(stringType);
		StringType defaultExtensionValue = StoreFactory.eINSTANCE.createStringType();
		defaultExtensionValue.setValue(getDefaultExtension());
		extensionParameter.setDefaultValue(defaultExtensionValue);
		objectDefinition.getParameters().add(extensionParameter);

		ParameterDefinition contentTypeParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		contentTypeParameter.setIdentifier(CONTENT_TYPE);
		contentTypeParameter.setName(CONTENT_TYPE);
		contentTypeParameter.setDescription("Content-Type in the HTTP header of the downloaded file");
		contentTypeParameter.setType(stringType);
		StringType defaultContentTypeValue = StoreFactory.eINSTANCE.createStringType();
		defaultContentTypeValue.setValue(getDefaultContentType());
		contentTypeParameter.setDefaultValue(defaultContentTypeValue);
		objectDefinition.getParameters().add(contentTypeParameter);
		return objectDefinition;
	}
	
	@Override
	public ObjectDefinition getSystemSettingsDefinition() {
		return null;
	}
	
	public abstract String getDefaultExtension();
	
	public abstract String getDefaultContentType();
	
	@Override
	public Set<String> getRequiredGeometryFields() {
		return null;
	}
}
