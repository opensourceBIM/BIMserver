package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.test.framework.TestFramework;

public class CheckinActionsFactory implements ActionFactory {
	private final List<Action> actions = new ArrayList<Action>();
	private final Random random = new Random();

	public CheckinActionsFactory(TestFramework testFramework) {
		add(1, new AddUserToProjectAction(testFramework));
		add(20, new CheckinAction(testFramework, new CheckinSettings()));
		add(1, new CreateProjectAction(testFramework));
		add(1, new CreateSubProjectAction(testFramework));
		add(5, new CreateUserAction(testFramework));
		add(1, new LoginAction(testFramework));
		add(1, new LogoutAction(testFramework));
		add(1, new RemoveUserFromProjectAction(testFramework));
	}
	
	public Action createAction() {
		return actions.get(random.nextInt(actions.size()));
	}

	private void add(int weight, Action action) {
		for (int i=0; i<weight; i++) {
			actions.add(action);
		}
	}
}