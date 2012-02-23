package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class ChangeRandomSettingAction extends Action {

	public ChangeRandomSettingAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		int random = nextInt(18);
		ServiceInterface serviceInterface = virtualUser.getBimServerClient().getServiceInterface();
		switch (random) {
		case 0:
			serviceInterface.setSettingAllowSelfRegistration(nextBoolean());
			break;
		case 1:
			serviceInterface.setSettingAllowUsersToCreateTopLevelProjects(nextBoolean());
			break;
		case 2:
			serviceInterface.setSettingAutoTestClashes(nextBoolean());
			break;
		case 3:
			serviceInterface.setSettingCacheOutputFiles(nextBoolean());
			break;
		case 4:
			serviceInterface.setSettingCheckinMergingEnabled(nextBoolean());
			break;
		case 5:
//			serviceInterface.setSettingCustomLogoAddress("");
			break;
		case 6:
//			serviceInterface.setSettingEmailSenderAddress("");
			break;
		case 7:
			serviceInterface.setSettingFooterAddition(randomString());
			break;
		case 8:
			serviceInterface.setSettingHeaderAddition(randomString());
			break;
		case 9:
			serviceInterface.setSettingHideUserListForNonAdmin(nextBoolean());
			break;
		case 10:
			serviceInterface.setSettingIntelligentMerging(nextBoolean());
			break;
		case 11:
			serviceInterface.setSettingMergeIdentifier(SMergeIdentifier.values()[nextInt(SMergeIdentifier.values().length)]);
			break;
		case 12:
			serviceInterface.setSettingProtocolBuffersPort(1024 + nextInt(1024));
			break;
		case 13:
			serviceInterface.setSettingRegistrationAddition(randomString());
			break;
		case 14:
			serviceInterface.setSettingSendConfirmationEmailAfterRegistration(nextBoolean());
			break;
		case 15:
			serviceInterface.setSettingShowVersionUpgradeAvailable(nextBoolean());
			break;
		case 16:
//			serviceInterface.setSettingSiteAddress("");
			break;
		case 17:
//			serviceInterface.setSettingSmtpServer("");
			break;
		}
	}
}