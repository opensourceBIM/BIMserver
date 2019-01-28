package org.bimserver.schemaconverter;

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

public class Ifc2x3tc1 {
	public static void main(String[] args) {
		Express2EMF express2emf = new Express2EMF(new File("deploy/IFC2X3_TC1.exp"), "ifc2x3tc1", "http://buildingsmart.ifc2x3tc1.ecore");
		express2emf.writeEMF("../BimServer/src/org/bimserver/database/migrations/steps/" + "IFC2X3_TC1.ecore");
	}
}