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
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.*;

public class SetAttributeChangeAtIndex implements Change {

	private final long oid;
	private final String attributeName;
	private final Object value;
	private int index;

	public SetAttributeChangeAtIndex(long oid, String attributeName, int index, Object value) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.index = index;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException, IOException, QueryException {
		PackageMetaData packageMetaData = transaction.getDatabaseSession().getMetaDataManager().getPackageMetaData(transaction.getProject().getSchema());

		Query query = new Query(packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.addOid(oid);
		
		HashMapVirtualObject object = transaction.get(oid);
		if (object == null) {
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(transaction.getDatabaseSession(), transaction.getBimServer(), query, Collections.singleton(transaction.getPreviousRevision().getOid()), packageMetaData);
			object = queryObjectProvider.next();
			transaction.updated(object);
		}
		
		EClass eClass = transaction.getDatabaseSession().getEClassForOid(oid);
		if (!ChangeHelper.canBeChanged(eClass)) {
			throw new UserException("Only objects from the following schemas are allowed to be changed: Ifc2x3tc1 and IFC4, this object (" + eClass.getName() + ") is from the \"" + eClass.getEPackage().getName() + "\" package");
		}

		object = transaction.get(oid);
		if (object == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + transaction.getProject().getId());
		}
		EAttribute eAttribute = packageMetaData.getEAttribute(eClass.getName(), attributeName);
		if (eAttribute == null) {
			throw new UserException("No attribute with the name \"" + attributeName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (!eAttribute.isMany()) {
			throw new UserException("Attribute is not of type 'many'");
		}
		if (value instanceof List) {
			throw new UserException("Value is list, only primitive values allowed.");
			// If this was a two-dimensional array we would have a structural feature, not an attribute referring to the inner array
		} else {
			if (eAttribute.getEType() instanceof EEnum) {
				EEnum eEnum = (EEnum) eAttribute.getEType();
				object.setListItem(eAttribute, index, eEnum.getEEnumLiteral(((String) value).toUpperCase()).getInstance());
			} else {
				object.setListItem(eAttribute, index, value);
			}
			if (value instanceof Double) {
				EStructuralFeature asStringAttribute = object.eClass().getEStructuralFeature(attributeName + "AsString");
				object.setListItem(asStringAttribute, index, String.valueOf((Double)value));
			}
		}
	}
}