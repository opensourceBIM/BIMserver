package org.bimserver.database.actions;

import org.bimserver.cache.CompareCache;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.file.compare.Compare;
import org.bimserver.ifc.file.compare.CompareResult;
import org.bimserver.shared.UserException;
import org.bimserver.shared.SCompareResult.SCompareType;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final SCompareType sCompareType;

	public CompareDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long roid1, long roid2, SCompareType sCompareType) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.roid1 = roid1;
		this.roid2 = roid2;
		this.sCompareType = sCompareType;
	}

	@Override
	public CompareResult execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Compare compare = new Compare(((DatabaseSession)getDatabaseSession()).getFieldIgnoreMap());
		CompareResult compareResults = CompareCache.getInstance().getCompareResults(roid1, roid2, sCompareType);
		if (compareResults == null) {
			IfcModel model1 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), roid1, actingUoid).execute();
			IfcModel model2 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), roid2, actingUoid).execute();
			compareResults = compare.compare(model1, model2, sCompareType);
			CompareCache.getInstance().storeResults(roid1, roid2, sCompareType, compareResults);
			return compareResults;
		} else {
			return compareResults;
		}
	}
}