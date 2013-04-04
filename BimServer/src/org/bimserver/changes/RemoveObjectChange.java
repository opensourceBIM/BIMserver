package org.bimserver.changes;

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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.database.actions.AbstractDownloadDatabaseAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class RemoveObjectChange implements Change {

	private final long oid;
	private EClass eClass;

	/**
	 * This is a potentially quite slow action
	 * 
	 * @param oid
	 * @param eClass
	 */
	public RemoveObjectChange(long oid, EClass eClass) {
		this.oid = oid;
		this.eClass = eClass;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, IdEObject> created) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		IdEObject idEObject = databaseSession.get(oid, new Query(project.getId(), concreteRevision.getId() - 1));
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}

		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(project, concreteRevision);
		Query query = new Query(project.getId(), concreteRevision.getId(), null, Deep.YES, highestStopId);
		IfcModel subModel = new IfcModel();
		databaseSession.getMap(subModel, query);
		for (IdEObject idEObject2 : subModel.getValues()) {
			boolean changed = false;
			for (EReference eReference : idEObject2.eClass().getEAllReferences()) {
				Object val = idEObject2.eGet(eReference);
				if (val != null) {
					if (eReference.isMany()) {
						List list = (List)val;
						Iterator iterator = list.iterator();
						while (iterator.hasNext()) {
							IdEObject item = (IdEObject) iterator.next();
							if (item == idEObject) {
								iterator.remove();
								changed = true;
							}
						}
					} else {
						IdEObject ref = (IdEObject)val;
						if (ref == idEObject) {
							idEObject2.eSet(eReference, null);
							changed = true;
						}
					}
				}
			}
			if (changed) {
				databaseSession.store(idEObject2, project.getId(), concreteRevision.getId());
			}
		}
		databaseSession.delete(idEObject);
	}
}
