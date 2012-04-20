package org.bimserver.test.framework.actions;

public abstract class ActionCreater {

	private int weight = 1;

	public abstract Action create();

	public ActionCreater() {
	}
	
	public ActionCreater(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
