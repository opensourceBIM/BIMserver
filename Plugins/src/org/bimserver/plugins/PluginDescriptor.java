package org.bimserver.plugins;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PluginDescriptor")
@XmlAccessorType(XmlAccessType.NONE)
public class PluginDescriptor {
	@XmlElement(name="PluginImplementation")
	private List<PluginImplementation> implementations = new ArrayList<PluginImplementation>();

	public void setImplementations(List<PluginImplementation> implementations) {
		this.implementations = implementations;
	}

	public List<PluginImplementation> getImplementations() {
		return implementations;
	}
}
