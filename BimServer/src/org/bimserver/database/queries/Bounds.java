package org.bimserver.database.queries;

public class Bounds {
	private double minX;
	private double minY;
	private double minZ;
	private double maxX;
	private double maxY;
	private double maxZ;

	public Bounds() {
		minX = Double.MAX_VALUE;
		minY = Double.MAX_VALUE;
		minZ = Double.MAX_VALUE;
		maxX = -Double.MAX_VALUE;
		maxY = -Double.MAX_VALUE;
		maxZ = -Double.MAX_VALUE;
	}
	
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

	public Bounds offset(int x, int y, int z) {
		return new Bounds(
			minX + (x == 1 ? getHalfWidth() : 0), 
			minY + (y == 1 ? getHalfHeight() : 0), 
			minZ + (z == 1 ? getHalfDepth() : 0), 
			maxX - (x == 0 ? getHalfWidth() : 0), 
			maxY - (y == 0 ? getHalfHeight() : 0), 
			maxZ - (z == 0 ? getHalfDepth() : 0));
	}

	public boolean within(Bounds bounds) {
		return getMinX() >= bounds.getMinX() && getMinY() >= bounds.getMinY() && getMinZ() >= bounds.getMinZ() && getMaxX() < bounds.getMaxX() && getMaxY() < bounds.getMaxY() && getMaxZ() < bounds.getMaxZ();
	}

	public void integrate(org.bimserver.models.geometry.Bounds bounds) {
		if (bounds.getMin().getX() < minX) {
			minX = bounds.getMin().getX();
		}
		if (bounds.getMin().getY() < minY) {
			minY = bounds.getMin().getY();
		}
		if (bounds.getMin().getZ() < minZ) {
			minZ = bounds.getMin().getZ();
		}
		if (bounds.getMax().getX() > maxX) {
			maxX = bounds.getMax().getX();
		}
		if (bounds.getMax().getY() > maxY) {
			maxY = bounds.getMax().getY();
		}
		if (bounds.getMax().getZ() > maxZ) {
			maxZ = bounds.getMax().getZ();
		}
	}
	
	@Override
	public String toString() {
		return minX + ", " + minY + ", " + minZ + " -- " + maxX + ", " + maxY + ", " + maxZ + " -- " + getWidth() + "x" + getHeight() + "x" + getDepth();
	}

	public double getWidth() {
		return getMaxX() - getMinX();
	}
	
	public double getHeight() {
		return getMaxY() - getMinY();
	}
	
	public double getDepth() {
		return getMaxZ() - getMinZ();
	}
	
	public double getHalfWidth() {
		return (getMaxX() - getMinX()) / 2f;
	}

	public double getHalfHeight() {
		return (getMaxY() - getMinY()) / 2f;
	}
	
	public double getHalfDepth() {
		return (getMaxZ() - getMinZ()) / 2f;
	}

	public void integrate(Bounds bounds) {
		if (bounds.getMinX() < minX) {
			minX = bounds.getMinX();
		}
		if (bounds.getMinY() < minY) {
			minY = bounds.getMinY();
		}
		if (bounds.getMinZ() < minZ) {
			minZ = bounds.getMinZ();
		}
		if (bounds.getMaxX() > maxX) {
			maxX = bounds.getMaxX();
		}
		if (bounds.getMaxY() > maxY) {
			maxY = bounds.getMaxY();
		}
		if (bounds.getMaxZ() > maxZ) {
			maxZ = bounds.getMaxZ();
		}
	}
}
