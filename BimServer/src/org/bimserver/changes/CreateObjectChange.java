package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.Map;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.GuidCompressor;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CreateObjectChange implements Change {

	private final long oid;
	private final String type;
	private IdEObjectImpl eObject;
	private EClass eClass;
	private Boolean generateGuid;

	public CreateObjectChange(String type, long oid, EClass eClass, Boolean generateGuid) {
		this.type = type;
		this.oid = oid;
		this.eClass = eClass;
		this.generateGuid = generateGuid;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	@Override
	public void execute(IfcModelInterface model, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, IdEObject> created, Map<Long, IdEObject> deleted) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		EClass eClass = databaseSession.getEClass(project.getSchema(), type);
		if (eClass == null) {
			throw new UserException("Type " + type + " does not exist");
		}
		eObject = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObject.setOid(oid);
		eObject.setPid(project.getId());
		eObject.setRid(concreteRevision.getId());
		eObject.setLoaded();
		try {
			model.add(oid, eObject);
		} catch (IfcModelInterfaceException e) {
			throw new UserException(e);
		}
		if (generateGuid) {
			EStructuralFeature globalIdFeature = eObject.eClass().getEStructuralFeature("GlobalId");
			if (globalIdFeature != null) {
				eObject.eSet(globalIdFeature, GuidCompressor.getNewIfcGloballyUniqueId());
			} else {
				throw new UserException("Cannot generate GUID for " + eObject.eClass().getName() + ", no GlobalId property");
			}
		}
		databaseSession.store(eObject, project.getId(), concreteRevision.getId());
		created.put(oid, eObject);
	}
}