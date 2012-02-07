package org.bimserver.satellite.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.client.ConnectionException;
import org.bimserver.client.notifications.NotificationLogger;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.satellite.SatelliteSettings;
import org.bimserver.satellite.activities.Activity;
import org.bimserver.satellite.activities.ExploderActivity;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.utils.SwingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SatelliteGui extends JFrame {

	private static final long serialVersionUID = -5428454520760923784L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SatelliteGui.class);
	protected static final String APP_NAME = "BIMserver Satellite";
	private SatelliteServer satelliteServer;
	private JButton connectDisconnectButton;
	private JTextArea logTextArea;
	private JTextArea notificationsTextArea;
	private SatelliteSettings settings;

	public static void main(String[] args) {
		SatelliteServer satelliteServer = new SatelliteServer();
		satelliteServer.registerActivity(new ExploderActivity());
		new SatelliteGui(satelliteServer);
	}

	public SatelliteGui(final SatelliteServer satelliteServer) {
		this.satelliteServer = satelliteServer;
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

		File settingsFile = new File("settings.xml");
		if (settingsFile.exists()) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(SatelliteSettings.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				settings = (SatelliteSettings) unmarshaller.unmarshal(settingsFile);
			} catch (JAXBException e) {
				LOGGER.error("", e);
			}
		}
		if (settings == null) {
			settings = new SatelliteSettings();
		}

		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));

		connectDisconnectButton = new JButton("Connect");

		connectDisconnectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (connectDisconnectButton.getText().equals("Connect")) {
					ConnectFrame connectFrame = new ConnectFrame(SatelliteGui.this, settings);
					connectFrame.setVisible(true);
				} else {
					satelliteServer.disconnect();
				}
			}
		});

		top.add(connectDisconnectButton);

		getContentPane().add(top, BorderLayout.NORTH);
		JTabbedPane tabber = new JTabbedPane();
		getContentPane().add(tabber, BorderLayout.CENTER);

		notificationsTextArea = new JTextArea();
		tabber.addTab("Notifications", new JScrollPane(notificationsTextArea));

		logTextArea = new JTextArea();
		tabber.addTab("Log", new JScrollPane(logTextArea));

		satelliteServer.getBimServerClient().registerConnectDisconnectListener(new ConnectDisconnectListener() {
			@Override
			public void connected() {
				connectDisconnectButton.setText("Disconnect");
				logTextArea.append("Connected\n");
				setTitle(SatelliteGui.APP_NAME + " - Connected");
			}

			@Override
			public void disconnected() {
				connectDisconnectButton.setText("Connect");
				logTextArea.append("Disconnected\n");
				setTitle(SatelliteGui.APP_NAME);
			}
		});

		for (Activity activity : satelliteServer.getActivities()) {
			final JTextArea activityTextArea = new JTextArea();
			JScrollPane activityScroll = new JScrollPane(activityTextArea);
			tabber.addTab(activity.getName(), activityScroll);
			activity.registerLogger(new ActivityLogger() {
				@Override
				public void log(String message) {
					activityTextArea.append(message + "\n");
				}
			});
		}

		if (settings.isAutoConnect()) {
			try {
				connect(settings);
			} catch (ConnectionException e) {
				LOGGER.error("", e);
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error connecting", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public SatelliteServer getSatelliteServer() {
		return satelliteServer;
	}

	public void connect(SatelliteSettings settings) throws ConnectionException {
		satelliteServer.connect(settings, new NotificationLogger(new PrintWriter(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				notificationsTextArea.append(new String(new char[] { (char) b }));
			}
		})));
	}
}