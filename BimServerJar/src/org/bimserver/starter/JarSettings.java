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

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class JarSettings {
	private File lastFile;

	@XmlElement
	private String jvm = "default";

	@XmlElement
	private String homedir = new File("home").getAbsolutePath();

	@XmlElement
	private String address = "localhost";

	@XmlElement
	private String proxyHost = "";

	@XmlElement
	private boolean useProxy = false;

	@XmlElement
	private int proxyPort = 1080;
	
	@XmlElement
	private int port = 8082;

	@XmlElement
	private String heapsize = "1024m";

	@XmlElement
	private String stacksize = "1024k";

	@XmlElement
	private boolean forceipv4 = false;

	@SuppressWarnings("restriction")
	public JarSettings() {
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		heapsize = Math.min(1024 * 1024 * 1024, physicalMemorySize / 2000000) + "m";
	}

	public static JarSettings readFromFile() {
		return readFromFile(new File("settings.xml"));
	}

	public static JarSettings readFromFile(File file) {
		if (file.exists()) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(JarSettings.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				JarSettings unmarshal = (JarSettings) unmarshaller.unmarshal(file);
				unmarshal.setLastFile(file);
				return unmarshal;
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else {
			return new JarSettings();
		}
		return null;
	}

	private void setLastFile(File lastFile) {
		this.lastFile = lastFile;
	}

	public void save() {
		if (lastFile == null) {
			lastFile = new File("settings.xml");
		}
		save(lastFile);
	}

	public void save(File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(JarSettings.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(this, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public String getJvm() {
		return jvm;
	}

	public void setJvm(String jvm) {
		this.jvm = jvm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setHomedir(String homedir) {
		this.homedir = homedir;
	}

	public String getHomedir() {
		return homedir;
	}

	public boolean isForceipv4() {
		return forceipv4;
	}

	public void setForceipv4(boolean forceipv4) {
		this.forceipv4 = forceipv4;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public boolean isUseProxy() {
		return useProxy;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}
}
