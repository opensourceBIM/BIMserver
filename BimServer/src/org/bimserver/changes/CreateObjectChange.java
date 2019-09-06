package org.bimserver.changes;

import java.util.UUID;

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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.GuidCompressor;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

public class CreateObjectChange implements Change {

	private final long oid;
	private final String type;
	private EClass eClass;
	private Boolean generateGuid;
	private UUID uuid;

	public CreateObjectChange(String type, long oid, EClass eClass, Boolean generateGuid) {
		this.type = type;
		this.oid = oid;
		this.uuid = UUID.randomUUID();
		this.eClass = eClass;
		this.generateGuid = generateGuid;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		PackageMetaData packageMetaData = transaction.getDatabaseSession().getMetaDataManager().getPackageMetaData(transaction.getProject().getSchema());

		QueryContext queryContext = new QueryContext(transaction.getDatabaseSession(), packageMetaData, transaction.getConcreteRevision().getProject().getId(), transaction.getNewRid(), -1, -1, 0); // TODO
		
		if (!ChangeHelper.canBeChanged(eClass)) {
			throw new UserException("Only objects from the following schemas are allowed to be changed: Ifc2x3tc1 and IFC4, this object (" + eClass.getName() + ") is from the \"" + eClass.getEPackage().getName() + "\" package");
		}

		HashMapVirtualObject object = new HashMapVirtualObject(queryContext, eClass, oid, uuid);
		
		if (generateGuid) {
			EAttribute globalIdFeature = (EAttribute) object.eClass().getEStructuralFeature("GlobalId");
			if (globalIdFeature != null) {
				object.setAttribute(globalIdFeature, GuidCompressor.getNewIfcGloballyUniqueId());
			} else {
				throw new UserException("Cannot generate GUID for " + object.eClass().getName() + ", no GlobalId property");
			}
		}
		
		transaction.created(object);
	}
}