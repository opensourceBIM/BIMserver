package org.bimserver.database.actions;

import org.bimserver.SettingsManager;
import org.bimserver.cache.CompareCache;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.file.compare.Compare;
import org.bimserver.ifc.file.compare.CompareResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.UserException;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final SCompareType sCompareType;
	private final SettingsManager settingsManager;

	public CompareDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, SettingsManager settingsManager, long actingUoid, long roid1, long roid2, SCompareType sCompareType) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
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
			IfcModel model1 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), settingsManager, roid1, actingUoid).execute();
			IfcModel model2 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), settingsManager, roid2, actingUoid).execute();
			compareResults = compare.compareOnNames(model1, model2, sCompareType);
//			compareResults = compare.compareOnGuids(model1, model2, sCompareType);
			CompareCache.getInstance().storeResults(roid1, roid2, sCompareType, compareResults);
			return compareResults;
		} else {
			return compareResults;
		}
	}
}