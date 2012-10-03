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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.utils.SwingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client extends JFrame {

	private static final long serialVersionUID = -3971471091403217662L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	public static final String APP_NAME = "BIMserver Client";
	private final ServiceHolder serviceHolder = new ServiceHolder();
	private final RevisionPanel revisionPanel;
	private final CheckoutsPanel checkoutsPanel;
	private final TreePanel treePanel;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		SwingUtil.setLookAndFeelToNice();
		try {
			setIconImage(ImageIO.read(getClass().getResource("logo_small.png")));
		} catch (IOException e) {
			LOGGER.error("", e);
		}

		revisionPanel = new RevisionPanel(serviceHolder, this);
		revisionPanel.setMinimumSize(new Dimension(200, 150));
		checkoutsPanel = new CheckoutsPanel(serviceHolder, this);
		checkoutsPanel.setMinimumSize(new Dimension(200, 150));
		treePanel = new TreePanel(this, serviceHolder);

		JMenu auth = new JMenu("File");
		JMenuItem changeAuth = new JMenuItem("(Re)connect");
		changeAuth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsFrame settingsFrame = new SettingsFrame(Client.this);
				settingsFrame.setVisible(true);
			}
		});
		auth.add(changeAuth);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(auth);
		setJMenuBar(menuBar);

		setTitle(APP_NAME + " - Not connected");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane right = new JSplitPane(JSplitPane.VERTICAL_SPLIT, revisionPanel, checkoutsPanel);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(300, 300));
		topPanel.add(treePanel, BorderLayout.WEST);
		topPanel.add(right, BorderLayout.CENTER);

		Console console = new Console();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, console);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		setVisible(true);
		ConsoleAppender.setLogHandler(console);
		setSize(640, 550);
		LOGGER.info("Application started");
	}

	public void checkin(SProject project) {
		JFileChooser chooser = new JFileChooser(".");
		int showOpenDialog = chooser.showOpenDialog(this);
		if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			FileDataSource dataSource = new FileDataSource(file);
			checkin(project, dataSource, file.length());
		}
	}

	public void checkin(SProject project, DataSource dataSource, long fileSize) {
		String comment = JOptionPane.showInputDialog(Client.this, "Please give a short description of your changes", "Checkin",
				JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
		try {
			DataHandler ifcFile = new DataHandler(dataSource);
			SDeserializerPluginConfiguration deserializerForExtension = serviceHolder.getService().getSuggestedDeserializerForExtension("ifc");
			String fileName = ifcFile.getName();
			long checkinId = serviceHolder.getService().checkin(project.getOid(), comment, deserializerForExtension.getOid(), fileSize, fileName, ifcFile, false, true);
			SCheckinResult sCheckinResult = serviceHolder.getService().getCheckinState(checkinId);
			JOptionPane.showMessageDialog(this, "New revision number: " + sCheckinResult.getRevisionId(), "Checkin successful", JOptionPane.OK_OPTION
					| JOptionPane.INFORMATION_MESSAGE);
			revisionPanel.showProject(project);
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(this, e.getUserMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	void checkout(SRevision revision, OutputStream out, boolean report) {
		try {
			SProject sProject = serviceHolder.getService().getProjectByPoid(revision.getProjectId());
			long longCheckoutActionId = serviceHolder.getService().checkout(revision.getOid(), -1L, true); // TODO select serializer oid
			SDownloadResult checkout = serviceHolder.getService().getDownloadData(longCheckoutActionId);
			try {
				InputStream inputStream = checkout.getFile().getInputStream();
				byte[] buffer = new byte[1024];
				int red = inputStream.read(buffer);
				int totalRed = 0;
				while (red != -1) {
					out.write(buffer, 0, red);
					totalRed += red;
					red = inputStream.read(buffer);
				}
				out.close();
				if (report) {
					JOptionPane.showMessageDialog(Client.this, "Revision: " + revision.getOid() + "\n" + totalRed + " bytes written",
							"Checkout successfull", JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
				}
				SProject project = new SProject();
				project.setName(sProject.getName());
				checkoutsPanel.showProject(project);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	void checkout(SRevision revision) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("IFC File", "ifc"));
		int showSaveDialog = chooser.showSaveDialog(this);
		if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			FileOutputStream fileOutputStream;
			try {
				fileOutputStream = new FileOutputStream(selectedFile);
				checkout(revision, fileOutputStream, true);
			} catch (FileNotFoundException e) {
				LOGGER.error("", e);
			}
		}
	}

	public void showProject(SProject project) {
		revisionPanel.showProject(project);
		checkoutsPanel.showProject(project);
	}

	public void showUser(SUser user) {
		revisionPanel.showUser(user);
		checkoutsPanel.showUser(user);
	}

	// public void processChangeSet(SProject project) {
	// JFileChooser chooser = new JFileChooser();
	// int showOpenDialog = chooser.showOpenDialog(this);
	// if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
	// File file = chooser.getSelectedFile();
	// processChangeSet(project, file);
	// }
	// }

	// private void processChangeSet(SProject project, File file) {
	// String showInputDialog = JOptionPane.showInputDialog(Client.this,
	// "Please give a short description of you changes", "Process ChangeSet",
	// JOptionPane.OK_OPTION
	// | JOptionPane.INFORMATION_MESSAGE);
	// JAXBContext context;
	// ChangeSet changeSet = null;
	// try {
	// context = JAXBContext.newInstance(ChangeSet.class);
	// Unmarshaller unmarshaller = context.createUnmarshaller();
	// changeSet = (ChangeSet) unmarshaller.unmarshal(new
	// FileInputStream(file));
	// } catch (JAXBException e) {
	// LOGGER.error("", e);
	// } catch (FileNotFoundException e) {
	// LOGGER.error("", e);
	// }
	// try {
	// ChangeSetResult upload =
	// serviceHolder.getService().processChangeSet(changeSet, project.getId(),
	// showInputDialog);
	// JOptionPane.showMessageDialog(this, "New revision number: " +
	// upload.getNewRevisionNr(), "Processing of ChangeSet successfull",
	// JOptionPane.OK_OPTION
	// | JOptionPane.INFORMATION_MESSAGE);
	// revisionPanel.showProject(project);
	// } catch (UserException e) {
	// LOGGER.error("", e);
	// }
	// }

	public void download(SRevision revision) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("IFC File", "ifc"));
		int showSaveDialog = chooser.showSaveDialog(this);
		if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(selectedFile);
				download(revision.getOid(), fileOutputStream, true);
			} catch (FileNotFoundException e) {
				LOGGER.error("", e);
			}
		}
	}

	public void download(long roid, FileOutputStream out, boolean report) {
		try {
			long downloadId = serviceHolder.getService().download(roid, -1L, true, true); // TODO
			SDownloadResult download = serviceHolder.getService().getDownloadData(downloadId);
			try {
				InputStream inputStream = download.getFile().getInputStream();
				IOUtils.copy(inputStream, out);
				out.close();
				if (report) {
					JOptionPane.showMessageDialog(Client.this, "Revision: " + download.getRevisionNr() + "\n", "Download successfull",
							JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	public ServiceHolder getServiceHolder() {
		return serviceHolder;
	}

	public void updateTree() {
		treePanel.updateTree();
	}

	public void expandTree() {
		treePanel.expandTree();
	}
}