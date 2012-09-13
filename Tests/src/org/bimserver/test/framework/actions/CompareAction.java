package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CompareAction extends Action {

//	private static final boolean VERBOSE = false;
	
	public CompareAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
//		SCompareType sCompareType = SCompareType.values()[nextInt(SCompareType.values().length)];
//		SCompareIdentifier sCompareIdentifier = SCompareIdentifier.values()[nextInt(SCompareIdentifier.values().length)];
//		SRevision revision1 = virtualUser.getRandomRevision();
//		SRevision revision2 = virtualUser.getRandomRevision();
//		if (revision1 != null && revision2 != null) {
//			getActionResults().setText("Comparing " + revision1.getId() + " with " + revision2.getId());
//			SCompareResult sCompareResult = virtualUser.getBimServerClient().getServiceInterface().compare(revision1.getOid(), revision2.getOid(), sCompareType, sCompareIdentifier);
//			if (VERBOSE) {
//				for (SCompareContainer sCompareContainer : sCompareResult.getItems()) {
//					virtualUser.getLogger().info(sCompareContainer.getType());
//					for (SCompareItem sCompareItem : sCompareContainer.getItems()) {
//						virtualUser.getLogger().info("\t" + sCompareItem);
//					}
//				}
//			}			
//		}
	}
}