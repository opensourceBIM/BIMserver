package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.compare.Compare;
import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GuidanceProviderException;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.UserException;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final SCompareType sCompareType;
	private final SCompareIdentifier sCompareIdentifier;
	private final BimServer bimServer;

	public CompareDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long roid1, long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
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
			guidanceProvider = bimServer.getPluginManager().requireGuidanceProvider();
		} catch (GuidanceProviderException e) {
			throw new UserException(e);
		}
		Compare compare = new Compare(guidanceProvider);
		CompareResult compareResults = bimServer.getCompareCache().getCompareResults(roid1, roid2, sCompareType, sCompareIdentifier);
		if (compareResults == null) {
			IfcModelInterface model1 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid1, actingUoid).execute();
			IfcModelInterface model2 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid2, actingUoid).execute();
			if (sCompareIdentifier == SCompareIdentifier.GUID_ID) {
				compareResults = compare.compareOnGuids(model1, model2, sCompareType);
			} else if (sCompareIdentifier == SCompareIdentifier.NAME_ID) {
				compareResults = compare.compareOnNames(model1, model2, sCompareType);
			}
			bimServer.getCompareCache().storeResults(roid1, roid2, sCompareType, sCompareIdentifier, compareResults);
			return compareResults;
		} else {
			return compareResults;
		}
	}
}