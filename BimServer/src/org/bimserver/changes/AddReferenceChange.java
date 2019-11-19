package org.bimserver.changes;

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

import java.io.IOException;
import java.util.Collections;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class AddReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final long referenceOid;

	public AddReferenceChange(long oid, String referenceName, long referenceOid) {
		this.oid = oid;
		this.referenceName = referenceName;
		this.referenceOid = referenceOid;
	}

	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException, IOException, QueryException {
		PackageMetaData packageMetaData = transaction.getDatabaseSession().getMetaDataManager().getPackageMetaData(transaction.getProject().getSchema());

		HashMapVirtualObject object = transaction.get(oid);
		if (object == null) {
			Query query = new Query(packageMetaData);
			QueryPart queryPart = query.createQueryPart();
			queryPart.addOid(oid);

			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(transaction.getDatabaseSession(), transaction.getBimServer(), query, Collections.singleton(transaction.getPreviousRevision().getOid()), packageMetaData);
			object = queryObjectProvider.next();
			transaction.updated(object);
		}
		
		EClass eClass = transaction.getDatabaseSession().getEClassForOid(oid);
		if (!ChangeHelper.canBeChanged(eClass)) {
			throw new UserException("Only objects from the following schemas are allowed to be changed: Ifc2x3tc1 and IFC4, this object (" + eClass.getName() + ") is from the \"" + eClass.getEPackage().getName() + "\" package");
		}
		if (object == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + transaction.getProject().getId());
		}
		EReference eReference = packageMetaData.getEReference(eClass.getName(), referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name \"" + referenceName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (!eReference.isMany()) {
			throw new UserException("Reference is not of type 'many'");
		}
		
		EClass eClassForOid = transaction.getDatabaseSession().getEClassForOid(referenceOid);
		
		object.addReference(eReference, eClassForOid, referenceOid);
		EReference inverseOrOpposite = packageMetaData.getInverseOrOpposite(eClassForOid, eReference);
		if (inverseOrOpposite != null) {
			HashMapVirtualObject referencedObject = transaction.get(referenceOid);
			if (referencedObject == null) {
				Query query = new Query(packageMetaData);
				QueryPart queryPart = query.createQueryPart();
				queryPart.addOid(referenceOid);
				
				QueryObjectProvider queryObjectProvider = new QueryObjectProvider(transaction.getDatabaseSession(), transaction.getBimServer(), query, Collections.singleton(transaction.getPreviousRevision().getOid()), packageMetaData);
				referencedObject = queryObjectProvider.next();
			}
			if (inverseOrOpposite.isMany()) {
				referencedObject.addReference(inverseOrOpposite, eClassForOid, oid);
			} else {
				referencedObject.setReference(inverseOrOpposite, oid);
			}
			transaction.updated(referencedObject);
		}
	}
}