package org.bimserver.starter;

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

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Starter extends JFrame {
	private static final long serialVersionUID = 5356018168589837130L;
	private Process exec;
	private JarSettingsProperties jarSettings = JarSettingsProperties.readFromFile();
	private JTextField addressField;
	private JTextField portField;
	private JTextField heapSizeField;
	private JButton browserHomeDir;
	private JTextField homeDirField;
	private JCheckBox useProxy;
	private JTextField proxyHost;
	private JTextField proxyPort;
	private JLabel proxyHostLabel;
	private JLabel proxyPortLabel;

	public static void main(String[] args) {
		new Starter().start();
	}

	public void save() {
		try {
			jarSettings.setAddress(addressField.getText());
			jarSettings.setPort(Integer.parseInt(portField.getText()));
			jarSettings.setHeapsize(heapSizeField.getText());
			jarSettings.setHomedir(homeDirField.getText());
			jarSettings.setUseProxy(useProxy.isSelected());
			jarSettings.setProxyHost(proxyHost.getText());
			jarSettings.setProxyPort(Integer.parseInt(proxyPort.getText()));
			jarSettings.save();
		} catch (Exception e) {
			// ignore
		}
	}
	
	private void start() {
		final JTextArea logField = new JTextArea();

		final PrintStream systemOut = System.out;
		
		PrintStream out = new PrintStream(new OutputStream() {
			@Override
			public void write(byte[] bytes, int off, int len) throws IOException {
				String str = new String(bytes, off, len);
				systemOut.append(str);
				logField.append(str);
				logField.setCaretPosition(logField.getDocument().getLength());
			}
			
			@Override
			public void write(int b) throws IOException {
				String str = new String(new char[] { (char) b });
				systemOut.append(str);
				logField.append(str);
				logField.setCaretPosition(logField.getDocument().getLength());
			}
		});
		System.setOut(out);
		System.setErr(out);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BIMserver Starter");
		try {
			setIconImage(ImageIO.read(getClass().getResource("logo_small.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(640, 500);
		getContentPane().setLayout(new BorderLayout());
		JPanel fields = new JPanel(new SpringLayout());

		JLabel homeDirLabel = new JLabel("Home directory");
		fields.add(homeDirLabel);

		homeDirField = new JTextField(jarSettings.getHomedir());
		browserHomeDir = new JButton("Browse...");
		browserHomeDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File currentFile = new File(homeDirField.getText());
				JFileChooser chooser = new JFileChooser(currentFile.exists() ? currentFile : new File("."));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int showOpenDialog = chooser.showOpenDialog(Starter.this);
				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					homeDirField.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		JPanel homeDirPanel = new JPanel();
		homeDirPanel.setLayout(new BorderLayout());
		homeDirPanel.add(homeDirField, BorderLayout.CENTER);
		homeDirPanel.add(browserHomeDir, BorderLayout.EAST);
		fields.add(homeDirPanel);
		
		JLabel addressLabel = new JLabel("Address");
		fields.add(addressLabel);

		addressField = new JTextField(jarSettings.getAddress());
		fields.add(addressField);

		JLabel portLabel = new JLabel("Port");
		fields.add(portLabel);

		portField = new JTextField(jarSettings.getPort() + "");
		fields.add(portField);

		JLabel heapSizeLabel = new JLabel("Max Heap Size");
		fields.add(heapSizeLabel);

		heapSizeField = new JTextField(jarSettings.getHeapsize());
		fields.add(heapSizeField);

		JLabel useProxyLabel = new JLabel("");
		useProxy = new JCheckBox("Use proxy server");
		useProxy.setSelected(jarSettings.isUseProxy());
		fields.add(useProxyLabel);
		fields.add(useProxy);
		
		proxyHostLabel = new JLabel("Proxy Host");
		fields.add(proxyHostLabel);
		
		proxyHost = new JTextField(jarSettings.getProxyHost());
		fields.add(proxyHost);
		
		proxyPortLabel = new JLabel("Proxy Port");
		fields.add(proxyPortLabel);
		
		proxyPort = new JTextField("" + jarSettings.getProxyPort());
		fields.add(proxyPort);
		
		SpringUtilities.makeCompactGrid(fields, 7, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		final JButton startStopButton = new JButton("Start");

		startStopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (startStopButton.getText().equals("Start")) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							setComponentsEnabled(false);
							File file = expand();
							startStopButton.setText("Stop");
							start(file, addressField.getText(), portField.getText(), heapSizeField.getText(), homeDirField.getText());
						}
					}, "BIMserver Starter Thread").start();
				} else if (startStopButton.getText().equals("Stop")) {
					if (exec != null) {
						exec.destroy();
						System.out.println("Server has been shut down");
						exec = null;
						startStopButton.setText("Start");
						setComponentsEnabled(true);
					}
				}
			}
		});
		
		final DocumentListener documentChangeListener = new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				save();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				save();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				save();
			}
		};

		homeDirField.getDocument().addDocumentListener(documentChangeListener);
		addressField.getDocument().addDocumentListener(documentChangeListener);
		portField.getDocument().addDocumentListener(documentChangeListener);
		heapSizeField.getDocument().addDocumentListener(documentChangeListener);
		useProxy.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateProxyVisibility();
				save();
			}
		});
		proxyHost.getDocument().addDocumentListener(documentChangeListener);
		proxyPort.getDocument().addDocumentListener(documentChangeListener);
		
		buttons.add(startStopButton);

		JButton launchWebBrowser = new JButton("Launch Webbrowser");
		launchWebBrowser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://" + addressField.getText() + ":" + portField.getText()));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		buttons.add(launchWebBrowser);

		logField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		logField.setEditable(true);
		logField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					exec.getOutputStream().write(e.getKeyChar());
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						exec.getOutputStream().flush();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(logField);
		getContentPane().add(fields, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(buttons, BorderLayout.SOUTH);
		
		updateProxyVisibility();

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				if (exec != null) {
					exec.destroy();
				}
			}
		}, "Thutdown Hook"));
		setVisible(true);
	}

	protected void updateProxyVisibility() {
		proxyHostLabel.setVisible(useProxy.isSelected());
		proxyPortLabel.setVisible(useProxy.isSelected());
		proxyHost.setVisible(useProxy.isSelected());
		proxyPort.setVisible(useProxy.isSelected());
	}

	private void setComponentsEnabled(boolean enabled) {
		addressField.setEditable(enabled);
		portField.setEditable(enabled);
		heapSizeField.setEditable(enabled);
		homeDirField.setEditable(enabled);
		browserHomeDir.setEnabled(enabled);
		proxyHost.setEnabled(enabled);
		proxyPort.setEnabled(enabled);
		useProxy.setEnabled(enabled);
	}
	
	private void start(File destDir, String address, String port, String heapsize, String homedir) {
		try {
			String os = System.getProperty("os.name");
			boolean isMac = os.toLowerCase().contains("mac");
			System.out.println("OS: " + os);
//			String command = "";

			checkJavaVersion();
			List<String> commands = new ArrayList<>();
			commands.add("java");
			commands.add("-Xmx" + heapsize);

//			boolean debug = true;
//			if (debug ) {
//				command += " -Xdebug -Xrunjdwp:transport=dt_socket,address=8998,server=y";
//			}
			
			if (useProxy.isSelected()) {
				commands.add("-Dhttp.proxyHost=" + proxyHost.getText());
				commands.add("-Dhttp.proxyPort=" + proxyPort.getText());
				commands.add("-Dhttps.proxyHost=" + proxyHost.getText());
				commands.add("-Dhttps.proxyPort=" + proxyPort.getText());
			}
			
			String cp = "." + File.pathSeparator;
			boolean escapeCompletePath = isMac;
//			if (escapeCompletePath) {
//				// OSX fucks up with single jar files escaped, so we try to escape the whole thing
//				command += "\"";
//			}
			cp += "lib" + File.pathSeparator;
			File dir = new File(destDir + File.separator + "lib");
			for (File lib : dir.listFiles()) {
				if (lib.isFile()) {
					if (lib.getName().contains(" ") && !escapeCompletePath) {
						cp += "\"lib" + File.separator + lib.getName() + "\"" + File.pathSeparator;
					} else {
						cp += "lib" + File.separator + lib.getName() + File.pathSeparator;
					}
				}
			}
			if (cp.endsWith(File.pathSeparator)) {
				cp = cp.substring(0, cp.length()-1);
			}
			commands.add("-Dorg.apache.cxf.Logger=org.apache.cxf.common.logging.Slf4jLogger");
			commands.add("-classpath");
			commands.add(cp);
//			if (escapeCompletePath) {
//				// OSX fucks up with single jar files escaped, so we try to escape the whole thing
//				command += "\"";
//			}
			Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			String realMainClass = "";
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				Manifest manifest = new Manifest(url.openStream());
				Attributes mainAttributes = manifest.getMainAttributes();
				for (Object key : mainAttributes.keySet()) {
					if (key.toString().equals("Real-Main-Class")) {
						realMainClass = mainAttributes.get(key).toString();
						break;
					}
				}
			}
			System.out.println("Main class: " + realMainClass);
			commands.add(realMainClass);
			commands.add("address=" + address);
			commands.add("port=" + port);
			commands.add("homedir=" + homedir);

			System.out.println("\nCommands:");
			for (String command : commands) {
				System.out.println(command);
			}
			ProcessBuilder processBuilder = new ProcessBuilder(commands);
			processBuilder.directory(destDir);
			
//			System.out.println("Running: " + command);
			exec = processBuilder.start();
//			exec = Runtime.getRuntime().exec(command, null, destDir);

			new Thread(new Runnable(){
				@Override
				public void run() {
					BufferedInputStream inputStream = new BufferedInputStream(exec.getInputStream());
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = inputStream.read(buffer);
						while (red != -1) {
							String s = new String(buffer, 0, red);
							System.out.print(s);
							red = inputStream.read(buffer);
						}
					} catch (IOException e) {
					}
				}}, "Sysin reader").start();
			new Thread(new Runnable(){
				@Override
				public void run() {
					BufferedInputStream errorStream = new BufferedInputStream(exec.getErrorStream());
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = errorStream.read(buffer);
						while (red != -1) {
							String s = new String(buffer, 0, red);
							System.out.print(s);
							red = errorStream.read(buffer);
						}
					} catch (IOException e) {
					}
				}}, "Syserr reader").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkJavaVersion() {
		List<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("-version");

		ProcessBuilder processBuilder = new ProcessBuilder(commands);
		try {
			exec = processBuilder.start();
			new Thread(new Runnable(){
				@Override
				public void run() {
					BufferedInputStream inputStream = new BufferedInputStream(exec.getInputStream());
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = inputStream.read(buffer);
						while (red != -1) {
							String s = new String(buffer, 0, red);
							System.out.print(s);
							red = inputStream.read(buffer);
						}
					} catch (IOException e) {
					}
				}}, "Sysin reader").start();
			new Thread(new Runnable(){
				@Override
				public void run() {
					BufferedInputStream errorStream = new BufferedInputStream(exec.getErrorStream());
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = errorStream.read(buffer);
						while (red != -1) {
							String s = new String(buffer, 0, red);
							System.out.print(s);
							red = errorStream.read(buffer);
						}
					} catch (IOException e) {
					}
				}}, "Syserr reader").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File expand() {
		JarFile jar = null;
		String jarFileName = getJarFileNameNew();
		File destDir = new File(jarFileName.substring(0, jarFileName.indexOf(".jar")));
		if (!destDir.isDirectory()) {
			System.out.println("Expanding " + jarFileName);
			try {
				jar = new java.util.jar.JarFile(jarFileName);
				Enumeration<JarEntry> enumr = jar.entries();
				while (enumr.hasMoreElements()) {
					JarEntry file = enumr.nextElement();
					System.out.println(file.getName());
					File f = new File(destDir, file.getName());
					if (file.isDirectory()) {
						if (!f.getParentFile().exists()) {
							f.getParentFile().mkdir();
						}
						f.mkdir();
						continue;
					}
					InputStream is = jar.getInputStream(file);
					FileOutputStream fos = new FileOutputStream(f);
					byte[] buffer = new byte[1024];
					int red = is.read(buffer);
					while (red != -1) {
						fos.write(buffer, 0, red);
						red = is.read(buffer);
					}
					fos.close();
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (jar != null) {
						jar.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("No expanding necessary");
		}
		return destDir;
	}

	private String getJarFileNameNew() {
		String name = this.getClass().getName().replace(".", "/") + ".class";
		URL urlJar = getClass().getClassLoader().getResource(name);
		String urlString = urlJar.getFile();
		urlString = urlString.substring(urlString.indexOf(":") + 1, urlString.indexOf("!"));
		try {
			return URLDecoder.decode(urlString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}