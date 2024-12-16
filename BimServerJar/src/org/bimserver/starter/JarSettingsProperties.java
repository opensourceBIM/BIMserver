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

	private static final String DEFAULT_JVM = "default";
	private static final String DEFAULT_STACKSIZE = "1024k";
	private static final String DEFAULT_HOMEDIR = new File("home").getAbsolutePath();
	private static final String DEFAULT_ADDRESS = "localhost";
	private static final int DEFAULT_PROXYPORT = 1080;
	private static final int DEFAULT_PORT =  8082;
	private static final String DEFAULT_HEAPSIZE;

	static {
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		DEFAULT_HEAPSIZE = 	Math.min(1024 * 1024 * 1024, physicalMemorySize / 2 / 1024 / 1024) + "m";
	}

	private String jvm;
	private String stacksize;
	private boolean forceipv4 = false;

	private String homedir;
	private String address;
	private boolean useProxy = false;
	private String proxyHost = "";
	private int proxyPort;
	private int port;
	private String heapsize;

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
				jarSettingsProperties.setJvm(properties.getProperty("jvm", DEFAULT_JVM));
				jarSettingsProperties.setStacksize(properties.getProperty("stacksize",DEFAULT_STACKSIZE));
				jarSettingsProperties.setForceipv4(Boolean.parseBoolean(properties.getProperty("forceip4")));
				jarSettingsProperties.setHomedir(properties.getProperty("homedir", DEFAULT_HOMEDIR));
				jarSettingsProperties.setAddress(properties.getProperty("address", DEFAULT_ADDRESS));
				jarSettingsProperties.setUseProxy(Boolean.parseBoolean(properties.getProperty("useProxy")));
				jarSettingsProperties.setProxyHost(properties.getProperty("proxyHost"));
				jarSettingsProperties.setProxyPort(Integer.parseInt(properties.getProperty("proxyPort", String.valueOf(DEFAULT_PROXYPORT))));
				jarSettingsProperties.setPort(Integer.parseInt(properties.getProperty("port", String.valueOf(DEFAULT_PORT))));
				jarSettingsProperties.setHeapsize(properties.getProperty("heapsize", DEFAULT_HEAPSIZE));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jarSettingsProperties;
	}
	
	public void save() {
		Properties properties = new Properties();

		properties.setProperty("jvm", getJvm());
		properties.setProperty("stacksize", getStacksize());
		properties.setProperty("forceipv4", String.valueOf(isForceipv4()));
		properties.setProperty("homedir", getHomedir());		
		properties.setProperty("address", getAddress());		
		properties.setProperty("useProxy", String.valueOf(isUseProxy()));
		properties.setProperty("proxyHost", getProxyHost());		
		properties.setProperty("proxyPort", String.valueOf(getProxyPort()));
		properties.setProperty("port", String.valueOf(getPort()));
		properties.setProperty("heapsize", getHeapsize());		

		try (OutputStream outputStream = Files.newOutputStream(Paths.get("settings.properties"))) {
			properties.store(outputStream, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getJvm() { return jvm; }

	public void setJvm(String jvm) { this.jvm = jvm; }

	public String getStacksize() { return stacksize; }

	public void setStacksize(String stacksize) { this.stacksize = stacksize; }

	public boolean isForceipv4() { return forceipv4; }

	public void setForceipv4(boolean forceipv4) { this.forceipv4 = forceipv4; }

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

}
