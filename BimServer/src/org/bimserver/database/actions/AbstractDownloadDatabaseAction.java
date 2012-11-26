package org.bimserver.database.actions;

import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;

public abstract class AbstractDownloadDatabaseAction<T> extends BimDatabaseAction<T> {

	public AbstractDownloadDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}
	
	protected void checkGeometry(SerializerPluginConfiguration serializerPluginConfiguration, IfcModelInterface subModel) {
		for (IfcProduct ifcProduct : subModel.getAllWithSubTypes(IfcProduct.class)) {
			if (serializerPluginConfiguration.isNeedsGeometry()) {
				GeometryInstance geometryInstance = ifcProduct.getGeometryInstance();
				if (geometryInstance != null) {
					geometryInstance.load();
				}
			}
			if (ifcProduct.getBounds() != null) {
				ifcProduct.getBounds().load();
				ifcProduct.getBounds().getMin().load();
				ifcProduct.getBounds().getMax().load();
			}
		}
	}
}