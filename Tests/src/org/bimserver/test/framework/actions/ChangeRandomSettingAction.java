package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import org.bimserver.shared.interfaces.ServiceInterface;
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
			getActionResults().setText("Setting allow self registration");
			serviceInterface.setSettingAllowSelfRegistration(nextBoolean());
			break;
		case 1:
			getActionResults().setText("Setting allow self registration");
			serviceInterface.setSettingAllowUsersToCreateTopLevelProjects(nextBoolean());
			break;
		case 3:
			getActionResults().setText("Setting allow self registration");
			serviceInterface.setSettingCacheOutputFiles(nextBoolean());
			break;
		case 4:
			getActionResults().setText("Setting checkin merin enabled");
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