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
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.DropMode;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreePanel extends JPanel {

	private static final long serialVersionUID = 659074905682926000L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TreePanel.class);
	private final JTree tree;
	private final ServiceHolder serviceHolder;
	private final ServerTreeNode serverTreeNode;

	public TreePanel(final Client testWindow, final ServiceHolder serviceHolder) {
		this.serviceHolder = serviceHolder;
		setLayout(new BorderLayout());

		RootTreeNode rootTreeNode = new RootTreeNode();
		serverTreeNode = new ServerTreeNode(rootTreeNode, "localhost");
		rootTreeNode.add(serverTreeNode);

		tree = new JTree(rootTreeNode);
		tree.setRootVisible(false);
		tree.setDropMode(DropMode.ON);
		tree.setTransferHandler(new TransferHandler() {
			private static final long serialVersionUID = -5283693046745987552L;

			@Override
			public boolean canImport(TransferSupport support) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean importData(TransferSupport support) {
				Transferable transferable = support.getTransferable();
				try {
					Object transferData = transferable.getTransferData(transferable.getTransferDataFlavors()[0]);
					List<File> list = (List<File>) transferData;
					File file = list.get(0);
					final FileInputStream fis = new FileInputStream(file);
					JTree.DropLocation dropLocation = (JTree.DropLocation) support.getDropLocation();
					final ProjectTreeNode ptn = (ProjectTreeNode) dropLocation.getPath().getLastPathComponent();
					testWindow.checkin(ptn.getProject(), new InputStreamDataSource(fis), file.length());
				} catch (UnsupportedFlavorException e) {
					LOGGER.error("", e);
				} catch (IOException e) {
					LOGGER.error("", e);
				}
				return true;
			}
		});

		tree.setPreferredSize(new Dimension(150, 500));
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				Object lastPathComponent = e.getPath().getLastPathComponent();
				if (lastPathComponent instanceof ProjectTreeNode) {
					testWindow.showProject(((ProjectTreeNode) lastPathComponent).getProject());
				} else if (lastPathComponent instanceof UserTreeNode) {
					testWindow.showUser(((UserTreeNode) lastPathComponent).getUser());
				}
			}
		});
		add(tree, BorderLayout.CENTER);

		final JPopupMenu projectsMenu = new JPopupMenu();

		final JPopupMenu userMenu = new JPopupMenu();
		final JMenuItem deleteUser = new JMenuItem("Delete");
		deleteUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object lastPathComponent = tree.getSelectionPath().getLastPathComponent();
				if (lastPathComponent instanceof UserTreeNode) {
					int showConfirmDialog = JOptionPane.showConfirmDialog(testWindow, "Are you sure you want to delete this user?", "Delete user", JOptionPane.YES_NO_OPTION);
					if (showConfirmDialog == JOptionPane.YES_OPTION) {
						try {
							serviceHolder.getService().deleteUser(((UserTreeNode) lastPathComponent).getUser().getOid());
						} catch (ServiceException e2) {
							JOptionPane.showMessageDialog(testWindow, e2.getMessage());
						}
						updateUsers(serverTreeNode);
					}
				}
			}
		});
		userMenu.add(deleteUser);

		final JPopupMenu usersMenu = new JPopupMenu();
		final JMenuItem addUser = new JMenuItem("Add User");
		addUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newUserName = JOptionPane.showInputDialog(testWindow, "What is the name of the new user?", "Add new user", JOptionPane.OK_OPTION
						| JOptionPane.INFORMATION_MESSAGE);
				try {
					serviceHolder.getService().addUser(newUserName, newUserName, SUserType.USER, false);
				} catch (ServiceException e1) {
					JOptionPane.showMessageDialog(testWindow, e1.getUserMessage());
				}
				updateUsers(serverTreeNode);
			}
		});
		usersMenu.add(addUser);

		final JPopupMenu serverMenu = new JPopupMenu();
		final JMenuItem addProject = new JMenuItem("Add Project");
		addProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newProjectName = JOptionPane.showInputDialog(testWindow, "What is the name of the new project?", "Add new project", JOptionPane.OK_OPTION
						| JOptionPane.INFORMATION_MESSAGE);
				if (newProjectName != null) {
					try {
						serviceHolder.getService().addProject(newProjectName);
					} catch (ServiceException e1) {
						JOptionPane.showMessageDialog(testWindow, e1.getUserMessage());
					}
					updateProjects(serverTreeNode);
				}
			}
		});
		final JMenuItem connectDisconnect = new JMenuItem("(Re)connect");
		connectDisconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (connectDisconnect.getText().equals("(Re)connect")) {
					SettingsFrame settingsFrame = new SettingsFrame(testWindow);
					settingsFrame.setVisible(true);
					// if
					// (TreePanel.this.serviceHolder.connect(testWindow.getServiceHolder().getAddress(),
					// testWindow.getServiceHolder().getUsername(),
					// testWindow.getServiceHolder().getPassword())) {
					// updateProjects(serverTreeNode);
					// updateUsers(serverTreeNode);
					// testWindow.setTitle("BIMserver Tester - " +
					// testWindow.getServiceHolder().getUsername());
					// projectTree.expandRow(0);
					// } else {
					// JOptionPane.showMessageDialog(testWindow,
					// "Connection failed", "Connection failed",
					// JOptionPane.ERROR_MESSAGE);
					// }
				} else {
					serviceHolder.disconnect();
					serverTreeNode.clearProjects();
					serverTreeNode.clearUsers();
					tree.updateUI();
					testWindow.setTitle("BIMserver Tester - Not connected");
					tree.collapseRow(0);
				}
			}
		});
		serverMenu.add(connectDisconnect);
		projectsMenu.add(addProject);

		final JMenuItem deleteProject = new JMenuItem("Delete");
		deleteProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object lastPathComponent = tree.getSelectionPath().getLastPathComponent();
				if (lastPathComponent instanceof ProjectTreeNode) {
					int showConfirmDialog = JOptionPane.showConfirmDialog(testWindow, "Are you sure you want to delete this project?", "Delete project", JOptionPane.YES_NO_OPTION);
					if (showConfirmDialog == JOptionPane.YES_OPTION) {
						try {
							serviceHolder.getService().deleteProject(((ProjectTreeNode) lastPathComponent).getProject().getOid());
							updateProjects(serverTreeNode);
						} catch (ServiceException e1) {
							LOGGER.error("", e1);
						}
					}
				}
			}
		});

		serverMenu.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if (!serviceHolder.isConnected()) {
					// connectDisconnect.setEnabled(true);
					// connectDisconnect.setText("Connect");
				} else {
					// connectDisconnect.setEnabled(false);
					// connectDisconnect.setText("Disconnect");
				}
			}
		});

//		final JMenuItem processChangeSet = new JMenuItem("Process ChangeSet...");
//		processChangeSet.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
//				testWindow.processChangeSet(ptn.getProject());
//			}
//		});

		final JPopupMenu projectMenu = new JPopupMenu();
		final JMenuItem checkin = new JMenuItem("Checkin new revision...");
		final JMenuItem checkout = new JMenuItem("Checkout latest revision...");
		checkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				try {
					SRevision revision = serviceHolder.getService().getRevision(ptn.getProject().getLastRevisionId());
					testWindow.checkout(revision);
				} catch (ServiceException e1) {
					LOGGER.error("", e1);
				}
			}
		});
		final JMenuItem download = new JMenuItem("Download latest revision...");
		download.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				try {
					SRevision revision = serviceHolder.getService().getRevision(ptn.getProject().getLastRevisionId());
					testWindow.download(revision);
				} catch (ServiceException e1) {
					LOGGER.error("", e1);
				}
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					int rowForLocation = tree.getRowForLocation(e.getX(), e.getY());
					if (rowForLocation != -1) {
						tree.setSelectionRow(rowForLocation);
					}
					if (tree.getSelectionPath() != null) {
						Object object = tree.getSelectionPath().getLastPathComponent();
						if (object instanceof ServerTreeNode) {
							serverMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof ProjectTreeNode) {
							projectMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof ProjectsTreeNode) {
							projectsMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof UsersTreeNode) {
							usersMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof UserTreeNode) {
							userMenu.show(tree, e.getX(), e.getY());
						}
					}
				}
			}
		});

		projectMenu.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				try {
					if (serviceHolder.getService().getAllRevisionsOfProject(((ProjectTreeNode) tree.getSelectionPath().getLastPathComponent()).getProject().getOid()) == null) {
						checkout.setEnabled(false);
						checkin.setText("Checkin initial revision...");
					} else {
						checkout.setEnabled(true);
						checkin.setText("Checkin new revision...");
					}
				} catch (ServiceException e1) {
					LOGGER.error("", e1);
				}
			}
		});
		checkin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				testWindow.checkin(ptn.getProject());
			}
		});
//		projectMenu.add(processChangeSet);
		projectMenu.add(checkin);
		projectMenu.addSeparator();
		projectMenu.add(checkout);
		projectMenu.add(download);
		projectMenu.addSeparator();
		projectMenu.add(deleteProject);
	}

	private void updateProjects(ServerTreeNode serverTreeNode) {
		try {
			List<SProject> projectList = serviceHolder.getService().getAllProjects(false);
			serverTreeNode.clearProjects();
			if (projectList != null) {
				for (SProject p : projectList) {
					ProjectTreeNode projectTreeNode = new ProjectTreeNode(p);
					serverTreeNode.add(projectTreeNode);
				}
			}
			tree.updateUI();
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
		}
	}

	private void updateUsers(ServerTreeNode serverTreeNode) {
		try {
			List<SUser> userList = serviceHolder.getService().getAllUsers();
			serverTreeNode.clearUsers();
			if (userList != null) {
				for (SUser u : userList) {
					UserTreeNode userTreeNode = new UserTreeNode(u);
					serverTreeNode.add(userTreeNode);
				}
			}
			tree.updateUI();
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
		}
	}

	public void updateTree() {
		updateProjects(serverTreeNode);
		updateUsers(serverTreeNode);
	}

	public void expandTree() {
		tree.expandRow(0);
	}
}