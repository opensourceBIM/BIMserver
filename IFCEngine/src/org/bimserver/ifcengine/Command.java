package org.bimserver.ifcengine;

import java.util.HashMap;
import java.util.Map;

public enum Command {
	CHECK_CONNECTION, OPEN_MODEL, OPEN_MODEL_STREAMING, SET_POSTPROCESSING, FINALIZE_MODELLING, INITIALIZE_MODELLING, GET_INSTANCES, GET_VISUALISATION_PROPERTIES, CLOSE_MODEL, FIND_CLASHES_BY_GUID, FIND_CLASHES_BY_EID, CLOSE;

	private static final Map<Byte, Command> map = initMap();
	private byte id;

	private static Map<Byte, Command> initMap() {
		byte idCounter = 0;
		HashMap<Byte, Command> hashMap = new HashMap<Byte, Command>();
		for (Command command : values()) {
			byte newId = idCounter++;
			command.setId(newId);
			hashMap.put(newId, command);
		}
		return hashMap;
	}

	public static Command getCommand(byte id) {
		return map.get(id);
	}
	
	public byte getId() {
		return id;
	}

	private void setId(byte id) {
		this.id = id;
	}
}