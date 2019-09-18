package org.bimserver.database.actions;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;

public abstract class AbstractDownloadDatabaseAction<T> extends BimDatabaseAction<T> {

	private Authorization authorization;
	private BimServer bimServer;

	public AbstractDownloadDatabaseAction(BimServer bimServer, DatabaseSession readOnlyDatabaseSession, AccessMethod accessMethod, Authorization authorization) {
		super(readOnlyDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
	}
	
	protected void checkGeometry(PluginConfiguration serializerPluginConfiguration, PluginManager pluginManager, IfcModelInterface model, Project project, ConcreteRevision concreteRevision, Revision revision) throws BimserverDatabaseException, GeometryGeneratingException {
		Set<String> needsGeometry = null;
		Plugin plugin = pluginManager.getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
		if (plugin instanceof SerializerPlugin) {
			needsGeometry = ((SerializerPlugin)plugin).getRequiredGeometryFields();
		}
		if (needsGeometry != null) {
			if (!revision.isHasGeometry()) {
//				setProgress("Generating geometry...", -1);
				// TODO When generating geometry for a partial model download (by types for example), this will fail (for example walls have no openings)
//				new GeometryGenerator(bimServer).generateGeometry(authorization.getUoid(), pluginManager, getDatabaseSession(), model, project.getId(), concreteRevision.getId(), false, null);
			} else {
				EClass productClass = model.getPackageMetaData().getEClass("IfcProduct");
				List<IdEObject> allWithSubTypes = new ArrayList<>(model.getAllWithSubTypes(productClass));
				for (IdEObject ifcProduct : allWithSubTypes) {
					ifcProduct.forceLoad();
					GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(productClass.getEStructuralFeature("geometry"));
					if (geometryInfo != null) {
						geometryInfo.forceLoad();
						geometryInfo.getData().forceLoad();
						if (needsGeometry.contains("colorsQuantized")) {
							geometryInfo.getData().getColorsQuantized().forceLoad();
						}
						if (needsGeometry.contains("indices")) {
							geometryInfo.getData().getIndices().forceLoad();
						}
						if (needsGeometry.contains("normals")) {
							geometryInfo.getData().getNormals().forceLoad();
						}
						if (needsGeometry.contains("normalsQuantized")) {
							geometryInfo.getData().getNormalsQuantized().forceLoad();
						}
						if (needsGeometry.contains("vertices")) {
							geometryInfo.getData().getVertices().forceLoad();
						}
						if (needsGeometry.contains("verticesQuantized")) {
							geometryInfo.getData().getVerticesQuantized().forceLoad();
						}
						geometryInfo.getData().getColor().forceLoad();
						geometryInfo.getTransformation();
						geometryInfo.getBounds().forceLoad();
						geometryInfo.getBounds().getMin().forceLoad();
						geometryInfo.getBounds().getMax().forceLoad();
					}
				}
			}
		}
	}

	public BimServer getBimServer() {
		return bimServer;
	}
	
	public static int findHighestStopRid(Project project, ConcreteRevision subRevision) {
		int highestStopId = Integer.MIN_VALUE;
		for (ConcreteRevision concreteRevision : project.getConcreteRevisions()) {
			// The id must at least be lower or the same as the version we are querying
			if (concreteRevision.getId() <= subRevision.getId()) {
				if (concreteRevision.isClear() && concreteRevision.getId() > highestStopId) {
					highestStopId = concreteRevision.getId();
				}
			}
		}
		return highestStopId;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}
}