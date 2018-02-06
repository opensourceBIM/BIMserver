package org.bimserver.changes;

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
		}
		
		if (object == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		
		transaction.deleted(object);
	}
}