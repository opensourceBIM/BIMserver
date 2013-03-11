package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		int random = nextInt(18);
		SettingsInterface settingsInterface = virtualUser.getBimServerClient().getSettingsInterface();
		switch (random) {
		case 0:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setSettingAllowSelfRegistration(nextBoolean());
			break;
		case 1:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setSettingAllowUsersToCreateTopLevelProjects(nextBoolean());
			break;
		case 3:
			virtualUser.getActionResults().setText("Setting allow self registration");
			settingsInterface.setSettingCacheOutputFiles(nextBoolean());
			break;
		case 4:
			virtualUser.getActionResults().setText("Setting checkin merin enabled");
			settingsInterface.setSettingCheckinMergingEnabled(nextBoolean());
			break;
		case 5:
//			serviceInterface.setSettingCustomLogoAddress("");
			break;
		case 6:
//			serviceInterface.setSettingEmailSenderAddress("");
			break;
		case 9:
			settingsInterface.setSettingHideUserListForNonAdmin(nextBoolean());
			break;
		case 12:
			settingsInterface.setSettingProtocolBuffersPort(1024 + nextInt(1024));
			break;
		case 14:
			settingsInterface.setSettingSendConfirmationEmailAfterRegistration(nextBoolean());
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