package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class ChangeRandomSettingAction extends Action {

	public ChangeRandomSettingAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		int random = nextInt(18);
		SettingsInterface settingsInterface = virtualUser.getBimServerClient().getSettingsInterface();
		switch (random) {
		case 0:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setAllowSelfRegistration(nextBoolean());
			break;
		case 1:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setAllowUsersToCreateTopLevelProjects(nextBoolean());
			break;
		case 3:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setCacheOutputFiles(nextBoolean());
			break;
		case 4:
			virtualUser.getActionResults().setText("Setting checkin merin enabled");
			settingsInterface.setCheckinMergingEnabled(nextBoolean());
			break;
		case 5:
//			serviceInterface.setSettingCustomLogoAddress("");
			break;
		case 6:
//			serviceInterface.setSettingEmailSenderAddress("");
			break;
		case 9:
			settingsInterface.setHideUserListForNonAdmin(nextBoolean());
			break;
		case 12:
			settingsInterface.setProtocolBuffersPort(1024 + nextInt(1024));
			break;
		case 14:
			settingsInterface.setSendConfirmationEmailAfterRegistration(nextBoolean());
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