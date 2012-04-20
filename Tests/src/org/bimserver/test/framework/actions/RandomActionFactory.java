package org.bimserver.test.framework.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomActionFactory implements ActionFactory {

	private final List<ActionCreater> actions = new ArrayList<ActionCreater>();

	public RandomActionFactory(ActionCreater... actions) {
		for (ActionCreater actionCreater : actions) {
			for (int i=0; i<actionCreater.getWeight(); i++) {
				this.actions.add(actionCreater);
			}
		}
	}

	@Override
	public Action createAction() {
		return actions.get(new Random().nextInt(actions.size())).create();
	}
}