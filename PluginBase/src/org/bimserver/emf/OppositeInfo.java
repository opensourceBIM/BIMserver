package org.bimserver.emf;

public class OppositeInfo {

	private boolean hasOpposites;
	private boolean hasManyOpposites;

	public OppositeInfo(boolean hasOpposites, boolean hasManyOpposites) {
		this.hasOpposites = hasOpposites;
		this.hasManyOpposites = hasManyOpposites;
	}
	
	public boolean isHasManyOpposites() {
		return hasManyOpposites;
	}
	
	public boolean isHasOpposites() {
		return hasOpposites;
	}
}