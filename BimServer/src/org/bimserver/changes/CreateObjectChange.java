package org.bimserver.changes;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.GuidCompressor;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
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
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		PackageMetaData packageMetaData = transaction.getDatabaseSession().getMetaDataManager().getPackageMetaData(transaction.getProject().getSchema());

		QueryContext queryContext = new QueryContext(transaction.getDatabaseSession(), packageMetaData, transaction.getConcreteRevision().getProject().getId(), transaction.getPreviousRevision() == null ? 1 : transaction.getPreviousRevision().getRid() + 1, -1, 0); // TODO
		
		HashMapVirtualObject object = new HashMapVirtualObject(queryContext, eClass, oid);
		
		if (generateGuid) {
			EStructuralFeature globalIdFeature = eObject.eClass().getEStructuralFeature("GlobalId");
			if (globalIdFeature != null) {
				eObject.eSet(globalIdFeature, GuidCompressor.getNewIfcGloballyUniqueId());
			} else {
				throw new UserException("Cannot generate GUID for " + eObject.eClass().getName() + ", no GlobalId property");
			}
		}
		
		transaction.created(object);
	}
}