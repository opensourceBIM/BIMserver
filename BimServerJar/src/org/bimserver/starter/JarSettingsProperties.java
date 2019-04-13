package org.bimserver.starter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class JarSettingsProperties {
	private File lastFile;

	private String jvm = "default";

	private String homedir = new File("home").getAbsolutePath();

	private String address = "localhost";

	private String proxyHost = "";

	private boolean useProxy = false;

	private int proxyPort = 1080;

	private int port = 8082;

	private String heapsize = "1024m";

	private String stacksize = "1024k";

	private boolean forceipv4 = false;

	public JarSettingsProperties() {
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		heapsize = Math.min(1024 * 1024 * 1024, physicalMemorySize / 2000000) + "m";
	}

	public static JarSettingsProperties readFromFile() {
		return readFromFile(Paths.get("settings.properties"));
	}
	
	public static JarSettingsProperties readFromFile(Path path) {
		JarSettingsProperties jarSettingsProperties = new JarSettingsProperties();
		Properties properties = new Properties();
		try {
			if (Files.exists(path)) {
				try (InputStream inputStream = Files.newInputStream(path)) {
					properties.load(inputStream);
				}
				jarSettingsProperties.setJvm(properties.getProperty("jvm"));
				jarSettingsProperties.setHomedir(properties.getProperty("homedir"));
				jarSettingsProperties.setAddress(properties.getProperty("address"));
				jarSettingsProperties.setUseProxy(Boolean.valueOf(properties.getProperty("useProxy")));
				jarSettingsProperties.setProxyHost(properties.getProperty("proxyHost"));
				jarSettingsProperties.setProxyPort(Integer.parseInt(properties.getProperty("proxyPort")));
				jarSettingsProperties.setPort(Integer.parseInt(properties.getProperty("port")));
				jarSettingsProperties.setHeapsize(properties.getProperty("heapsize"));
				jarSettingsProperties.setStacksize(properties.getProperty("stacksize"));
				jarSettingsProperties.setForceipv4(Boolean.valueOf(properties.getProperty("forceipv4")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jarSettingsProperties;
	}
	
	public void save() {
		Properties properties = new Properties();
		
		properties.setProperty("jvm", getJvm());		
		properties.setProperty("homedir", getHomedir());		
		properties.setProperty("address", getAddress());		
		properties.setProperty("useProxy", "" + isUseProxy());		
		properties.setProperty("proxyHost", getProxyHost());		
		properties.setProperty("proxyPort", "" + getProxyPort());		
		properties.setProperty("port", "" + getPort());		
		properties.setProperty("heapsize", getHeapsize());		
		properties.setProperty("stacksize", getStacksize());		
		properties.setProperty("forceipv4", "" + isForceipv4());
		
		try (OutputStream outputStream = Files.newOutputStream(Paths.get("settings.properties"))) {
			properties.store(outputStream, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getLastFile() {
		return lastFile;
	}

	public void setLastFile(File lastFile) {
		this.lastFile = lastFile;
	}

	public String getJvm() {
		return jvm;
	}

	public void setJvm(String jvm) {
		this.jvm = jvm;
	}

	public String getHomedir() {
		return homedir;
	}

	public void setHomedir(String homedir) {
		this.homedir = homedir;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public boolean isUseProxy() {
		return useProxy;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHeapsize() {
		return heapsize;
	}

	public void setHeapsize(String heapsize) {
		this.heapsize = heapsize;
	}

	public String getStacksize() {
		return stacksize;
	}

	public void setStacksize(String stacksize) {
		this.stacksize = stacksize;
	}

	public boolean isForceipv4() {
		return forceipv4;
	}

	public void setForceipv4(boolean forceipv4) {
		this.forceipv4 = forceipv4;
	}
}
