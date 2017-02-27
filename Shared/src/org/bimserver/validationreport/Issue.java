package org.bimserver.validationreport;

import java.awt.image.BufferedImage;

public class Issue {

	private BufferedImage image;

	public void addImage(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
