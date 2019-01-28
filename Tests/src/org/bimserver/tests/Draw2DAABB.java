package org.bimserver.tests;

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
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.queries.Bounds;
import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class Draw2DAABB extends JFrame {
	private static final long serialVersionUID = -7491304257510795972L;
	private int width = 1024;
	private int height = 768;
	private final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	public static void main(String[] args) {
		new Draw2DAABB();
	}
	
	public Draw2DAABB() {
		setTitle("2D AABBs");
		setSize(width, height + 20);
		
		createImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void createImage() {
		Graphics graphics = image.getGraphics();
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				List<SProjectSmall> allRelatedProjects = client.getServiceInterface().getAllRelatedProjects(13500417L);
				Bounds totalBounds = new Bounds();
				Bounds screenBounds = new Bounds(0, 0, 0, width, height, 1000);
				for (SProjectSmall projectSmall : allRelatedProjects) {
					if (projectSmall.getLastRevisionId() != -1 && projectSmall.getNrSubProjects() == 0) {
						SProject project = client.getServiceInterface().getProjectByPoid(projectSmall.getOid());
						SBounds bounds = client.getServiceInterface().getModelBounds(project.getLastRevisionId());
						if (bounds != null) {
							totalBounds.integrate(new Bounds(bounds));
						}
					}
				}
				System.out.println("Model bounds: " + totalBounds);
				System.out.println("Screen bounds: " + screenBounds);
				for (SProjectSmall projectSmall : allRelatedProjects) {
					if (projectSmall.getLastRevisionId() != -1 && projectSmall.getNrSubProjects() == 0) {
						SProject project = client.getServiceInterface().getProjectByPoid(projectSmall.getOid());
						SBounds bounds = client.getServiceInterface().getModelBounds(project.getLastRevisionId());
						if (bounds != null) {
							Bounds subModelBounds = new Bounds(bounds);
							Bounds subModelScreenBounds = subModelBounds.scale(totalBounds, screenBounds);
							
						}
					}
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintAll(Graphics g) {
		super.paintAll(g);
		g.drawImage(image, 0, 0, this);
	}
}
