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
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class SetWrappedAttributeChange implements Change {

	private Long oid;
	private String attributeName;
	private String type;
	private Object value;

	public SetWrappedAttributeChange(Long oid, String attributeName, String type, Object value) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.type = type;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException,
			BimserverDatabaseException, IOException, QueryException {
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

		if (object == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + transaction.getProject().getId());
		}
		EReference eReference = packageMetaData.getEReference(eClass.getName(), attributeName);
		if (eReference == null) {
			throw new UserException("No reference with the name \"" + attributeName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (value instanceof List && eReference.isMany()) {
			List sourceList = (List)value;
			if (!eReference.isMany()) {
				throw new UserException("Attribute is not of type 'many'");
			}
			List list = (List)object.eGet(eReference);
			for (Object o : sourceList) {
				if (eReference.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
					List asStringList = (List)object.eGet(object.eClass().getEStructuralFeature(attributeName + "AsString"));
					asStringList.add(String.valueOf(o));
				}
				list.add(o);
			}
		} else {
			if (eReference.isMany()) {
				throw new UserException("Attribute is not of type 'single'");
			}
			if (eReference.getEType() instanceof EEnum) {
				EEnum eEnum = (EEnum) eReference.getEType();
				object.set(eReference.getName(), eEnum.getEEnumLiteral(((String) value).toUpperCase()).getInstance());
			} else {
				EClass typeEClass = (EClass) packageMetaData.getEClassifier(type);
				if (typeEClass.getEAnnotation("wrapped") == null) {
					throw new UserException("Not a wrapped type");
				}
				HashMapWrappedVirtualObject wrappedObject = new HashMapWrappedVirtualObject(typeEClass);
				if (typeEClass == Ifc2x3tc1Package.eINSTANCE.getIfcBoolean()) {
					if ((Boolean)value == true) {
						value = Tristate.TRUE;
					} else {
						value = Tristate.FALSE;
					}
				}
				wrappedObject.set(wrappedObject.eClass().getEStructuralFeature("wrappedValue").getName(), value);
				object.set(eReference.getName(), wrappedObject);
				if (value instanceof Double) {
					wrappedObject.set(wrappedObject.eClass().getEStructuralFeature("wrappedValueAsString").getName(), String.valueOf((Double)value));
				}
			}
		}
	}
}