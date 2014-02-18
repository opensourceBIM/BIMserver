package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;

public class Step0009 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		if (databaseSession != null) {
			try {
				IfcModelInterface projects = databaseSession.getAllOfType(StorePackage.eINSTANCE.getProject(), Query.getDefault());
				for (Project project : projects.getAll(Project.class)) {
					for (Revision revision : project.getRevisions()) {
						IfcModelInterface allOfType = databaseSession.getAllOfType(Ifc2x3tc1Package.eINSTANCE.getGeometryData(), new Query(project.getId(), revision.getId()));
						for (GeometryData geometryData : allOfType.getAll(GeometryData.class)) {
							System.out.println("Updating geometry data for " + geometryData.getOid());
							ByteBuffer buffer = ByteBuffer.wrap(geometryData.getVertices());
							convertOrder(buffer);
							buffer = ByteBuffer.wrap(geometryData.getNormals());
							convertOrder(buffer);
							databaseSession.store(geometryData);
						}
					}
				}
			} catch (BimserverDatabaseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void convertOrder(ByteBuffer input) {
		if (input.order() != ByteOrder.nativeOrder()) {
			input.position(0);
			for (int i = 0; i < input.capacity(); i += 4) {
				input.order(ByteOrder.BIG_ENDIAN);
				float x = input.getFloat();
				input.order(ByteOrder.nativeOrder());
				input.position(input.position() - 4);
				input.putFloat(x);
			}
			input.position(0);
		}
	}

	@Override
	public String getDescription() {
		return "Store an optional transformation matrix with GeometryInfo";
	}
}