package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutsPanel extends JPanel {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutsPanel.class);
	private static final long serialVersionUID = -8031235575978078294L;

	private CheckoutTableModel checkoutTableModel;
	private JTable checkoutTable;

	public CheckoutsPanel(final ServiceHolder serviceHolder, final Client testWindow) {
		setLayout(new BorderLayout());
		JLabel label = new JLabel("Checkouts");
		add(label, BorderLayout.NORTH);
		
		checkoutTableModel = new CheckoutTableModel(serviceHolder);
		checkoutTable = new JTable();

		checkoutTable.setModel(checkoutTableModel);
		checkoutTable.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton() == MouseEvent.BUTTON1) {
					final SCheckout checkout = checkoutTableModel.getCheckout(checkoutTable.getSelectedRow());
					File tmp = new File("tmp");
					if (!tmp.isDirectory()) {
						tmp.mkdir();
					}
					SProject sProject;
					try {
						sProject = serviceHolder.getService().getProjectByPoid(checkout.getProjectId());
						File file = new File(tmp, sProject.getName() + "." + checkout.getRevisionId() + ".ifc");
						try {
							testWindow.download(checkout.getRevisionId(), new FileOutputStream(file), false);
							Desktop.getDesktop().open(file);
						} catch (FileNotFoundException e) {
							LOGGER.error("", e);
						} catch (IOException e) {
							LOGGER.error("", e);
						}
					} catch (ServiceException e) {
						LOGGER.error("", e);
					}
				}
			}
		});
		
		JScrollPane scrollpaneCheckouts = new JScrollPane(checkoutTable);
		add(scrollpaneCheckouts, BorderLayout.CENTER);
	}

	public void showProject(SProject project) {
		checkoutTableModel.showProject(project);
	}

	public void showUser(SUser user) {
		checkoutTableModel.showUser(user);
	}
}