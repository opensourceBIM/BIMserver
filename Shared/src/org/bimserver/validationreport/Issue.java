package org.bimserver.validationreport;

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

import java.awt.image.BufferedImage;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;

public class Issue {

	private String originatigModelCheckName;
	private BufferedImage image;
	private Type type;
	private String message;
	private IfcBuildingStorey ifcBuildingStorey;
	private Object is;
	private Object shouldBe;
	private IdEObject object;
	private String author;

	public BufferedImage getImage() {
		return image;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public void setIs(Object is) {
		this.is = is;
	}

	public void setShouldBe(Object shouldBe) {
		this.shouldBe = shouldBe;
	}

	public void setObject(IdEObject object) {
		this.object = object;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Type getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public IfcBuildingStorey getIfcBuildingStorey() {
		return ifcBuildingStorey;
	}

	public Object getIs() {
		return is;
	}

	public Object getShouldBe() {
		return shouldBe;
	}

	public IdEObject getObject() {
		return object;
	}

	@Override
	public String toString() {
		return "Issue\n" + object + " " + message;
	}

	public String getOriginatigModelCheckName() {
		return originatigModelCheckName;
	}

	public void setOriginatigModelCheckName(String originatigModelCheckName) {
		this.originatigModelCheckName = originatigModelCheckName;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
