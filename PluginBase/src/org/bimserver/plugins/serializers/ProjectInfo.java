package org.bimserver.plugins.serializers;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import org.bimserver.interfaces.objects.SBounds;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.interfaces.objects.SVector3f;

public class ProjectInfo {
	private String name;
	private String description;
	private double x;
	private double y;
	private double z;
	private double directionAngle;
	private String authorName;
	private SBounds boundsUntranslated;
	private SBounds bounds;
	private float multiplierToMm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getDirectionAngle() {
		return directionAngle;
	}

	public void setDirectionAngle(double directionAngle) {
		this.directionAngle = directionAngle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public SVector3f getMinBounds() {
		return bounds.getMin();
	}
	
	public SBounds getBounds() {
		return bounds;
	}

	public SBounds getBoundsUntranslated() {
		return boundsUntranslated;
	}
	
	public void setBoundsUntranslated(SBounds boundsUntranslated) {
		this.boundsUntranslated = boundsUntranslated;
	}
	
	public SVector3f getMaxBounds() {
		return bounds.getMax();
	}

	public void setBounds(SBounds bounds) {
		this.bounds = bounds;
	}

	public float getMultiplierToMm() {
		return multiplierToMm;
	}
	
	public void setMultiplierToMm(float multiplierToMm) {
		this.multiplierToMm = multiplierToMm;
	}
}