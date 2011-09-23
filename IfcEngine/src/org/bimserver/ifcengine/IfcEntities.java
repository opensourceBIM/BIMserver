/**
 * 
 */
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

public enum IfcEntities {
	WINDOW, ANNOTATION, BEAM, BUILDINGELEMENTCOMPONENT, STRUCTURALCURVEMEMBER, STRUCTURALSURFACEMEMBER, BUILDINGELEMENTPROXY, COLUMN, COVERING, CURTAINWALL, DOOR, ELEMENTASSEMBLY, FASTENER, FOOTING, MECHANICALFASTENER, MEMBER, PILE, PLATE, RAILING, RAMP, RAMPFLIGHT, ROOF, SLAB, STAIR, STAIRFLIGHT, SPACE, WALL, WALLSTANDARDCASE, AIRTERMINAL, DISTRIBUTIONELEMENT, ENERGYCONVERSIONDEVICE, FURNISHINGELEMENT, FLOWCONTROLLER, FLOWFITTING, FLOWMOVINGDEVICE, FLOWSEGMENT, FLOWSTORAGEDEVICE, FLOWTERMINAL, FLOWTREATMENTDEVICE, GRID;

	@Override
	public String toString() {
		return "IFC" + name();
	}

}
