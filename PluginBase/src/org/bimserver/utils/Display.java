package org.bimserver.utils;

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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Display extends JFrame {

	private static final long serialVersionUID = -4323346123771019062L;
	private BufferedImage bufferedImage;

	public Display(String title, int width, int height) {
		setTitle(title);
		setSize(width, height + 10);
		setVisible(true);
	}
	
	public Display(String title, int width, int height, Area area) {
		this(title, width, height);
		double scaleX = (width * 0.9) / area.getBounds().getWidth();
		double scaleY = (height * 0.9) / area.getBounds().getHeight();
		double scale = Math.min(scaleX, scaleY);
		
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.translate(width / 2, height / 2);
		affineTransform.scale(scale, scale);
		affineTransform.translate(-area.getBounds2D().getCenterX(), -area.getBounds2D().getCenterY());

		area.transform(affineTransform);
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.fill(area);
		
		this.bufferedImage = image;
	}
	
	public void setImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bufferedImage, 0, 0, this);
	}
}
