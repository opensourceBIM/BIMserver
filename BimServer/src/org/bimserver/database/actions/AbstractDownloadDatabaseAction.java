package org.bimserver.database.actions;

import org.bimserver.GeometryGenerator;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Bounds;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Geometry;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.plugins.PluginManager;

public abstract class AbstractDownloadDatabaseAction<T> extends BimDatabaseAction<T> {

	public AbstractDownloadDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}
	
	protected void checkGeometry(SerializerPluginConfiguration serializerPluginConfiguration, PluginManager pluginManager, IfcModelInterface model, Project project, ConcreteRevision concreteRevision, Revision revision) throws BimserverDatabaseException {
		if (serializerPluginConfiguration.isNeedsGeometry()) {
			if (revision.getGeometry() == null) {
				setProgress("Generating geometry...", -1);
				new GeometryGenerator().generateGeometry(pluginManager, getDatabaseSession(), model, project.getId(), concreteRevision.getId(), revision, false);
			} else {
				Geometry geometry = revision.getGeometry();
				geometry.load();
				model.setGeometry(geometry);
				for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
					GeometryInstance geometryInstance = ifcProduct.getGeometryInstance();
					if (geometryInstance != null) {
						geometryInstance.load();
					}
					Bounds bounds = ifcProduct.getBounds();
					if (bounds != null) {
						bounds.load();
						if (bounds.getMin() != null) {
							bounds.getMin().load();
						}
						if (bounds.getMax() != null) {
							bounds.getMax().load();
						}
					}
				}
			}
		}
	}
}