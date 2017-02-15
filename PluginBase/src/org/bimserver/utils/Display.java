package org.bimserver.utils;

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
