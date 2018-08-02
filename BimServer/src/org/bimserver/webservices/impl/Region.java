package org.bimserver.webservices.impl;

import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Vector3f;

public class Region {
	private float[] min = new float[3];
	private float[] max = new float[3];

	public Region(Bounds bounds) {
		this.min[0] = (float) bounds.getMin().getX();
		this.min[1] = (float) bounds.getMin().getY();
		this.min[2] = (float) bounds.getMin().getZ();
		this.max[0] = (float) bounds.getMax().getX();
		this.max[1] = (float) bounds.getMax().getY();
		this.max[2] = (float) bounds.getMax().getZ();
	}

	public boolean canAccept(Bounds bounds) {
		float minDistance = 0;
		for (int d = 0; d < 3; d++) {
			float aMin = get(bounds.getMin(), d);
			float aMax = get(bounds.getMax(), d);
			float bMin = min[d];
			float bMax = max[d];
			if (aMin > bMax) {
				float delta = bMax - aMin;
				minDistance += delta * delta;
			} else if (bMin > aMax) {
				float delta = aMax - bMin;
				minDistance += delta * delta;
			}
		}
		return minDistance < 10000;
	}

	private float get(Vector3f input, int d) {
		if (d == 0) {
			return (float) input.getX();
		} else if (d == 1) {
			return (float) input.getY();
		} else if (d == 2) {
			return (float) input.getZ();
		}
		return 0;
	}

	public void integrate(Bounds bounds) {
		if (bounds.getMin().getX() < this.min[0]) {
			this.min[0] = (float) bounds.getMin().getX();
		}
		if (bounds.getMin().getY() < this.min[1]) {
			this.min[1] = (float) bounds.getMin().getY();
		}
		if (bounds.getMin().getZ() < this.min[2]) {
			this.min[2] = (float) bounds.getMin().getZ();
		}
		if (bounds.getMax().getX() > this.max[0]) {
			this.max[0] = (float) bounds.getMax().getX();
		}
		if (bounds.getMax().getY() > this.max[1]) {
			this.max[1] = (float) bounds.getMax().getY();
		}
		if (bounds.getMax().getZ() > this.max[2]) {
			this.max[2] = (float) bounds.getMax().getZ();
		}
	}

	public SBounds toSBounds() {
		SBounds sBounds = new SBounds();
		SVector3f min = new SVector3f();
		SVector3f max = new SVector3f();
		min.setX(this.min[0]);
		min.setY(this.min[1]);
		min.setZ(this.min[2]);
		max.setX(this.max[0]);
		max.setY(this.max[1]);
		max.setZ(this.max[2]);
		sBounds.setMin(min);
		sBounds.setMax(max);
		return sBounds;
	}
}