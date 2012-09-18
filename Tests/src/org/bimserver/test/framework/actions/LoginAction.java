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
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class LoginAction extends Action {

	public LoginAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (nextInt(virtualUser.getUserNames().size() + 1) == 0) {
			getActionResults().setText("Logging in as admin@bimserver.org");
			virtualUser.getBimServerClient().getServiceInterface().login("admin@bimserver.org", "admin");
		} else {
			if (!virtualUser.getUserNames().isEmpty()) {
				String username = virtualUser.getRandomUserName();
				getActionResults().setText("Logging in as " + username);
				virtualUser.getBimServerClient().getServiceInterface().login(username, "test");
			}
		}
	}
}
