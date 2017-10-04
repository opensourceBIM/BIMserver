package org.bimserver.changes;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

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
		object = transaction.get(oid);
		if (object == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + transaction.getProject().getId());
		}
		EAttribute eAttribute = packageMetaData.getEAttribute(eClass.getName(), attributeName);
		if (eAttribute == null) {
			throw new UserException("No attribute with the name \"" + attributeName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (value instanceof List && eAttribute.isMany()) {
			List sourceList = (List)value;
			if (!eAttribute.isMany()) {
				throw new UserException("Attribute is not of type 'many'");
			}
			List list = (List)object.eGet(eAttribute);
			list.clear();
			List asStringList = null;
			if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
				asStringList = (List)object.eGet(object.eClass().getEStructuralFeature(attributeName + "AsString"));
				asStringList.clear();
			}
			for (Object o : sourceList) {
				if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
					asStringList.add(String.valueOf(o));
				}
				list.add(o);
			}
		} else {
			if (eAttribute.isMany()) {
				throw new UserException("Attribute is not of type 'single'");
			}
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