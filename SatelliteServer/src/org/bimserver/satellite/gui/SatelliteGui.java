package org.bimserver.satellite.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import org.bimserver.satellite.SatelliteServer;
import org.bimserver.utils.SwingUtil;

public class SatelliteGui extends JFrame {

	private static final long serialVersionUID = -5428454520760923784L;
	protected static final String APP_NAME = "BIMserver Satellite";
	private SatelliteServer satelliteServer = new SatelliteServer();
	
	public static void main(String[] args) {
		new SatelliteGui();
	}
	
	public SatelliteGui() {
		SwingUtil.setLookAndFeelToNice();
		try {
			setIconImage(ImageIO.read(getClass().getResource("logo_small.png")));
		} catch (IOException e) {
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setTitle(APP_NAME);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		JButton connectButton = new JButton("Connect");
		
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectFrame connectFrame = new ConnectFrame(SatelliteGui.this);
				connectFrame.setVisible(true);
			}
		});
		
		top.add(connectButton);
		
		getContentPane().add(top, BorderLayout.NORTH);
		JTabbedPane tabber = new JTabbedPane();
		getContentPane().add(tabber, BorderLayout.CENTER);
		
		JTextArea notificationsTextArea = new JTextArea();
		tabber.addTab("Notifications", new JScrollPane(notificationsTextArea));

		JTextArea logTextArea = new JTextArea();
		tabber.addTab("Log",  new JScrollPane(logTextArea));
	}

	public SatelliteServer getSatelliteServer() {
		return satelliteServer;
	}
}