package org.bimserver.test.framework.actions;

import java.util.Random;

public class FixedActionFactory implements ActionFactory {

	private Action[] actions;

	public FixedActionFactory(Action... actions) {
		this.actions = actions;
	}
	
	@Override
	public Action createAction() {
		return actions[new Random().nextInt(actions.length)];
	}
}
