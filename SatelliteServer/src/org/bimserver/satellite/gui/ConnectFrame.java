package org.bimserver.satellite.gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import org.bimserver.utils.AutoSelectTextField;
import org.bimserver.utils.SpringUtilities;

public class ConnectFrame extends JDialog {
	private static final long serialVersionUID = -3385875607460570310L;

	public ConnectFrame(final SatelliteGui satelliteGui) {
		setIconImage(satelliteGui.getIconImage());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Connect");
		getContentPane().setLayout(new SpringLayout());
		JLabel usernameLabel = new JLabel("Username");
		getContentPane().add(usernameLabel);
		final AutoSelectTextField usernameField = new AutoSelectTextField(20);
		usernameField.setText("");
		getContentPane().add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password");
		getContentPane().add(passwordLabel);
		final AutoSelectTextField passwordField = new AutoSelectTextField(20);
		passwordField.setText("");
		getContentPane().add(passwordField);
		
		JLabel serverLabel = new JLabel("Server address");
		getContentPane().add(serverLabel);
		final AutoSelectTextField serverField = new AutoSelectTextField(25);
		serverField.setText("");
		getContentPane().add(serverField);

		JLabel portLabel = new JLabel("Port");
		getContentPane().add(portLabel);
		final AutoSelectTextField portField = new AutoSelectTextField(5);
		portField.setText("");
		getContentPane().add(portField);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		getContentPane().add(cancel);
		
		JButton save = new JButton("Connect");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
				try {
					satelliteGui.getSatelliteServer().connect(serverField.getText(), Integer.parseInt(portField.getText()), usernameField.getText(), passwordField.getText());
					setVisible(false);
					satelliteGui.setTitle(SatelliteGui.APP_NAME + " - Connected to " + usernameField.getText() + "@" + serverField.getText());
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(satelliteGui, exception.getMessage(), "Error connecting", JOptionPane.ERROR_MESSAGE);
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}});
		getContentPane().add(save);
		getRootPane().setDefaultButton(save);

		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		Action escapeAction = new AbstractAction() {
			private static final long serialVersionUID = 8237515446053964032L;

			public void actionPerformed(ActionEvent e) {
		        dispose();
		    }
		}; 
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
		getRootPane().getActionMap().put("ESCAPE", escapeAction);
		
		SpringUtilities.makeCompactGrid(getContentPane(),
                5, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		pack();
		setLocationRelativeTo(satelliteGui);
	}
}
