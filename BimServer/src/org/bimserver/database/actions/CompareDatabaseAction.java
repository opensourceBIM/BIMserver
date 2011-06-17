package org.bimserver.database.actions;

import org.bimserver.MergerFactory;
import org.bimserver.SettingsManager;
import org.bimserver.cache.CompareCache;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.compare.Compare;
import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GuidanceProviderException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.shared.UserException;
import org.bimserver.shared.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.SCompareResult.SCompareType;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final SCompareType sCompareType;
	private final SettingsManager settingsManager;
	private final SCompareIdentifier sCompareIdentifier;
	private final MergerFactory mergerFactory;
	private final PluginManager pluginManager;

	public CompareDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, SettingsManager settingsManager, MergerFactory mergerFactory, PluginManager pluginManager, long actingUoid, long roid1, long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
		this.mergerFactory = mergerFactory;
		this.pluginManager = pluginManager;
		this.actingUoid = actingUoid;
		this.roid1 = roid1;
		this.roid2 = roid2;
		this.sCompareType = sCompareType;
		this.sCompareIdentifier = sCompareIdentifier;
	}

	@Override
	public CompareResult execute() throws UserException, BimDeadlockException, BimDatabaseException {
		GuidanceProvider guidanceProvider;
		try {
			guidanceProvider = pluginManager.requireGuidanceProvider();
		} catch (GuidanceProviderException e) {
			throw new UserException(e);
		}
		Compare compare = new Compare(guidanceProvider);
		CompareResult compareResults = CompareCache.getInstance().getCompareResults(roid1, roid2, sCompareType, sCompareIdentifier);
		if (compareResults == null) {
			IfcModel model1 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), settingsManager, mergerFactory, roid1, actingUoid).execute();
			IfcModel model2 = new DownloadDatabaseAction(getDatabaseSession(), getAccessMethod(), settingsManager, mergerFactory, roid2, actingUoid).execute();
			if (sCompareIdentifier == SCompareIdentifier.GUID_ID) {
				compareResults = compare.compareOnGuids(model1, model2, sCompareType);
			} else if (sCompareIdentifier == SCompareIdentifier.NAME_ID) {
				compareResults = compare.compareOnNames(model1, model2, sCompareType);
			}
			CompareCache.getInstance().storeResults(roid1, roid2, sCompareType, sCompareIdentifier, compareResults);
			return compareResults;
		} else {
			return compareResults;
		}
	}
}