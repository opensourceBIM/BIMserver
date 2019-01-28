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
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.store.Authorization;

public class IssueBuilder {

	private Type type;
	private IssueContainer issueContainer;
	private String message;
	private IfcBuildingStorey ifcBuildingStorey;
	private BufferedImage image;
	private IdEObject object;
	private Object is;
	private Object shouldBe;
	private String originatingCheck;
	private String author;

	public IssueBuilder(IssueContainer issueContainer) {
		this.issueContainer = issueContainer;
	}
	
	public String getObjectIdentifier(IfcProduct ifcProduct) {
		if (ifcProduct == null) {
			return "No object";
		}
		String name = ifcProduct.getName();
		if (name != null && !name.trim().equals("")) {
			return name;
		}
		String guid = ifcProduct.getGlobalId();
		if (guid != null && !guid.trim().equals("")) {
			return guid;
		}
		return ifcProduct.eClass().getName() + " " + ifcProduct.getOid();
	}
	
	public IssueBuilder type(Type type) {
		this.type = type;
		return this;
	}

	public IssueBuilder object(IdEObject object) {
		this.object = object;
		return this;
	}

	public void add() {
		issueContainer.add(this.create());
	}

	private Issue create() {
		Issue issue = new Issue();
		if (type != null) {
			issue.setType(type);
		}
		if (message != null) {
			issue.setMessage(message);
		}
		if (ifcBuildingStorey != null) {
			issue.setIfcBuildingStorey(ifcBuildingStorey);
		}
		if (is != null) {
			issue.setIs(is);
		}
		if (shouldBe != null) {
			issue.setShouldBe(shouldBe);
		}
		if (object != null) {
			issue.setObject(object);
		}
		if (image != null) {
			issue.setImage(image);
		}
		if (originatingCheck != null) {
			issue.setOriginatigModelCheckName(originatingCheck);
		}
		if (author != null) {
			issue.setAuthor(author);
		}
		return issue;
	}
	
	public IssueBuilder author(String author) {
		this.author = author;
		return this;
	}

	public IssueBuilder message(String message) {
		this.message = message;
		return this;
	}

	public IssueBuilder buildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
		return this;
	}

	public IssueBuilder image(BufferedImage image) {
		this.image = image;
		return this;
	}

	public IssueBuilder is(Object is) {
		this.is = is;
		return this;
	}

	public IssueBuilder shouldBe(Object object) {
		this.shouldBe = object;
		return this;
	}

	public IssueBuilder originatingCheck(String originatingCheck) {
		this.originatingCheck = originatingCheck;
		return this;
	}
}