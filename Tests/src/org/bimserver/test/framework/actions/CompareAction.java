package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SCompareContainer;
import org.bimserver.interfaces.objects.SCompareIdentifier;
import org.bimserver.interfaces.objects.SCompareItem;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CompareAction extends Action {

	public CompareAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SCompareType sCompareType = SCompareType.values()[nextInt(SCompareType.values().length)];
		SCompareIdentifier sCompareIdentifier = SCompareIdentifier.values()[nextInt(SCompareIdentifier.values().length)];
		SRevision revision1 = virtualUser.getRandomRevision();
		SRevision revision2 = virtualUser.getRandomRevision();
		if (revision1 != null && revision2 != null) {
			getActionResults().setText("Comparing " + revision1.getId() + " with " + revision2.getId());
			SCompareResult sCompareResult = virtualUser.getBimServerClient().getServiceInterface().compare(revision1.getOid(), revision2.getOid(), sCompareType, sCompareIdentifier);
			for (SCompareContainer sCompareContainer : sCompareResult.getItems()) {
				virtualUser.getLogger().info(sCompareContainer.getType());
				for (SCompareItem sCompareItem : sCompareContainer.getItems()) {
					virtualUser.getLogger().info("\t" + sCompareItem);
				}
			}
		}
	}
}