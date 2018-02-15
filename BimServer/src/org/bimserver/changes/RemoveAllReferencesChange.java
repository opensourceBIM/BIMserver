package org.bimserver.changes;

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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class RemoveAllReferencesChange implements Change {

	private Long oid;
	private String referenceName;

	public RemoveAllReferencesChange(Long oid, String referenceName) {
		this.oid = oid;
		this.referenceName = referenceName;
	}

	@SuppressWarnings("rawtypes")
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
		EReference eReference = packageMetaData.getEReference(eClass.getName(), referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name \"" + referenceName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (!eReference.isMany()) {
			throw new UserException("Reference is not of type 'many'");
		}
		List list = (List) object.get(eReference.getName());
		while (!list.isEmpty()) {
			list.remove(0);
		}
	}
}
