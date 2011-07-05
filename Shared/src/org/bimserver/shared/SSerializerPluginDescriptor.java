package org.bimserver.shared;

public class SSerializerPluginDescriptor {
	private String pluginClassName;
	private String defaultName;
	private String defaultExtension;
	private String defaultContentType;

	public String getPluginClassName() {
		return pluginClassName;
	}

	public void setPluginClassName(String pluginClassName) {
		this.pluginClassName = pluginClassName;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public String getDefaultExtension() {
		return defaultExtension;
	}

	public void setDefaultExtension(String defaultExtension) {
		this.defaultExtension = defaultExtension;
	}

	public String getDefaultContentType() {
		return defaultContentType;
	}

	public void setDefaultContentType(String defaultContentType) {
		this.defaultContentType = defaultContentType;
	}
}