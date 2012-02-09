package org.bimserver.test.framework.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.test.framework.TestFramework;

public class ActionFactory {
	private final List<Action> actions = new ArrayList<Action>();
	private final Random random = new Random();
	
	public ActionFactory(TestFramework testFramework) {
		add(new AddUserToProjectAction(testFramework));
		add(new CheckinAction(testFramework));
		add(new CheckoutAction(testFramework));
		add(new CreateProjectAction(testFramework));
		add(new CreateSubProjectAction(testFramework));
		add(new CreateUserAction(testFramework));
		add(new DownloadRevisionAction(testFramework));
		add(new LoginAction(testFramework));
		add(new LogoutAction(testFramework));
		add(new RemoveUserFromProjectAction(testFramework));
		add(new UpdateProjectAction(testFramework));
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
