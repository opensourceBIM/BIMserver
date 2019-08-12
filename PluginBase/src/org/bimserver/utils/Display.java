package org.bimserver.utils;

import java.awt.Color;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Display extends JFrame {

	private static final long serialVersionUID = -4323346123771019062L;
	private BufferedImage bufferedImage;
	private Area area;

	public Display(String title, int width, int height) {
		setTitle(title);
		setSize(width, height + 10);
		setVisible(true);
	}
	
	public Display(String title, int width, int height, Area area) {
		this(title, width, height);
		this.area = area;
		
		redraw();
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				redraw();
			}
		});
	}

	public void redraw() {
		int width = getWidth();
		int height = getHeight();
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
		graphics.setColor(Color.GREEN);
		graphics.fill(area);
		graphics.setColor(Color.RED);
		graphics.draw(area);
		
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
