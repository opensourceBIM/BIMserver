package org.bimserver.shared;

public class SPlugin {
	public enum SPluginState {
		ENABLED("Enabled"),
		DISABLED("Disabled");
		
		private final String niceName;

		SPluginState(String niceName) {
			this.niceName = niceName;
		}

		public String getNiceName() {
			return niceName;
		}
	}
	
	private String name;
	private String description;
	private String location;
	private SPluginState state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setState(SPluginState state) {
		this.state = state;
	}

	public SPluginState getState() {
		return state;
	}
}