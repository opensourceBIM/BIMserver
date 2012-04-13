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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.test.framework.TestFramework;

public class AllActionsFactory implements ActionFactory {
	private final List<Action> actions = new ArrayList<Action>();
	private final Random random = new Random();
	
	public AllActionsFactory(TestFramework testFramework) {
		add(new CompareAction(testFramework));
		add(new DownloadModelLowLevel(testFramework));
		add(new DumpDataObjects(testFramework));
		add(new AddUserToProjectAction(testFramework));
		add(new CheckinAction(testFramework, new CheckinSettings()));
		add(new CheckoutAction(testFramework));
		add(new CreateProjectAction(testFramework));
		add(new CreateSubProjectAction(testFramework));
		add(new CreateUserAction(testFramework));
		add(new DownloadRevisionAction(testFramework));
		add(new LoginAction(testFramework));
		add(new LogoutAction(testFramework));
		add(new RemoveUserFromProjectAction(testFramework));
		add(new UpdateProjectAction(testFramework));
		add(new PingAction(testFramework));
		add(new UpdateRevisionAction(testFramework));
	}
	
	public Action createAction() {
		return actions.get(random.nextInt(actions.size()));
	}

	private void add(Action action) {
		for (int i=0; i<action.getWeight(); i++) {
			actions.add(action);
		}
	}
}