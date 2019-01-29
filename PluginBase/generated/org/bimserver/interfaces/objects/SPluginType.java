package org.bimserver.interfaces.objects;

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

public enum SPluginType {
	SERIALIZER(0),
	DESERIALIZER(1),
	RENDER_ENGINE(2),
	QUERY_ENGINE(3),
	OBJECT_IDM(4),
	WEB_MODULE(5),
	MODEL_MERGER(6),
	MODEL_COMPARE(7),
	MODEL_CHECKER(8),
	STILL_IMAGE_RENDER(9),
	SERVICE(10);
	int ordinal;

	SPluginType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}