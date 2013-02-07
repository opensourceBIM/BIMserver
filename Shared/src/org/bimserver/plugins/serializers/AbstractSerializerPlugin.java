package org.bimserver.plugins.serializers;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;

public abstract class AbstractSerializerPlugin implements SerializerPlugin {
	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();

		ParameterDefinition extensionParameter = StoreFactory.eINSTANCE.createParameterDefinition();
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
		contentTypeParameter.setName(CONTENT_TYPE);
		contentTypeParameter.setDescription("Content-Type in the HTTP header of the downloaded file");
		contentTypeParameter.setType(stringType);
		StringType defaultContentTypeValue = StoreFactory.eINSTANCE.createStringType();
		defaultContentTypeValue.setValue(getDefaultContentType());
		contentTypeParameter.setDefaultValue(defaultContentTypeValue);
		objectDefinition.getParameters().add(contentTypeParameter);
		return objectDefinition;
	}
	
	public abstract String getDefaultExtension();
	
	public abstract String getDefaultContentType();
}
