package org.bimserver.validationreport;

import java.awt.image.BufferedImage;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcProduct;

public class IssueBuilder {

	private Type type;
	private IssueContainer issueContainer;
	private String message;
	private IfcBuildingStorey ifcBuildingStorey;
	private BufferedImage image;
	private IdEObject object;
	private Object is;
	private Object shouldBe;

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
		return issue;
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
}