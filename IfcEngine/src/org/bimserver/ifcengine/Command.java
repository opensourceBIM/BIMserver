package org.bimserver.ifcengine;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import java.util.HashMap;
import java.util.Map;

public enum Command {
	/*
	 * DO NOT CHANGE ORDER!!!
	 */
	
	CHECK_CONNECTION, 
	OPEN_MODEL, 
	OPEN_MODEL_STREAMING, 
	SET_POSTPROCESSING, 
	FINALIZE_MODELLING, 
	INITIALIZE_MODELLING, 
	GET_INSTANCES, 
	GET_VISUALISATION_PROPERTIES, 
	CLOSE_MODEL, 
	FIND_CLASHES_BY_GUID, 
	FIND_CLASHES_BY_EID, 
	CLOSE, 
	GET_INSTANCE_FROM_EXPRESSID,
	SET_FORMAT,
	GET_TRANSFORMATION_MATRIX, 
	INITIALIZE_MODELLING_INSTANCE,
	OPEN_MODEL_STREAMING_PARTS,
	SET_FILTER,
	GET_AREA, 
	GET_VOLUME;

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