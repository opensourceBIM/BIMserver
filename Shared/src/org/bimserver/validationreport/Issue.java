package org.bimserver.validationreport;

import java.awt.image.BufferedImage;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;

public class Issue {

	private BufferedImage image;
	private Type type;
	private String message;
	private IfcBuildingStorey ifcBuildingStorey;
	private Object is;
	private Object shouldBe;
	private IdEObject object;

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
	
	
}
