package org.bimserver.ifcengine;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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