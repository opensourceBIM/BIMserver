package org.bimserver.database.queries;

public class Bounds {
	private double minX;
	private double minY;
	private double minZ;
	private double maxX;
	private double maxY;
	private double maxZ;

	public Bounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public Bounds(org.bimserver.models.geometry.Bounds bounds) {
		this.minX = bounds.getMin().getX();
		this.minY = bounds.getMin().getY();
		this.minZ = bounds.getMin().getZ();
		this.maxX = bounds.getMax().getX();
		this.maxY = bounds.getMax().getY();
		this.maxZ = bounds.getMax().getZ();
	}
	
	public double getMinX() {
		return minX;
	}
	
	public double getMaxX() {
		return maxX;
	}
	
	public double getMaxY() {
		return maxY;
	}
	
	public double getMaxZ() {
		return maxZ;
	}
	
	public double getMinY() {
		return minY;
	}
	
	public double getMinZ() {
		return minZ;
	}

	public Bounds offset(double x, double y, double z) {
		return new Bounds(minX + x, minY + y, minZ + z, maxX + x, maxY + y, maxZ + z);
	}

	public boolean within(Bounds bounds) {
		return bounds.getMinX() > getMinX() && bounds.getMinY() > getMinY() && bounds.getMinZ() > getMinZ() && bounds.getMaxX() < getMaxX() && bounds.getMaxY() > getMaxY() && bounds.getMaxZ() > getMaxZ();
	}
}
