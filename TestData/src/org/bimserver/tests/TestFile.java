package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

public enum TestFile {
	EXPORT1(new File(TestFileConstants.DATA_FOLDER, "export1.ifc")),
	EXPORT3(new File(TestFileConstants.DATA_FOLDER, "export3.ifc")),
	NIEDRI(new File(TestFileConstants.DATA_FOLDER, "Niedri_org.ifc")),
	MERGE_TEST_SOURCE_FILE(new File(TestFileConstants.DATA_FOLDER, "MergeTest.ifc")), 
	HITOS_SOURCE_FILE(new File(TestFileConstants.DATA_FOLDER, "HITOS_070308.ifc")), 
	HAUS_SOURCE_FILE(new File(TestFileConstants.DATA_FOLDER, "AC9R1-Haus-G-H-Ver2-2x3.ifc")), 
	AC11_XML(new File(TestFileConstants.DATA_FOLDER, "AC11-Institute-Var-2-ifcXML.ifcxml")), 
	SIX_SPACES_XML(new File(TestFileConstants.DATA_FOLDER, "SixSpaces.ifcxml")), 
	RIOLERING_TEST(new File(TestFileConstants.DATA_FOLDER, "RioleringTestArkey.ifc")), 
	EMPTY_TEST(new File(TestFileConstants.DATA_FOLDER, "EmptyTest.ifc")), 
	WALL_ONLY(new File(TestFileConstants.DATA_FOLDER, "WallOnly.ifc")),
	WALL_ONLY_ADDED_SPACE(new File(TestFileConstants.DATA_FOLDER, "WallOnlyAddedSpace.ifc")),
	AC11(new File(TestFileConstants.DATA_FOLDER, "AC11-Institute-Var-2-IFC.ifc")), 
	REVIT_QUANTITIES(new File(TestFileConstants.DATA_FOLDER, "revit_quantities.ifc")), 
	BATHROOM(new File(TestFileConstants.DATA_FOLDER, "BathroomWindow.ifc")),
	JASMIN(new File(TestFileConstants.DATA_FOLDER, "AC90R1-Jasmin-Sun-105-2x3.ifc")),
	ADTHAUS(new File(TestFileConstants.DATA_FOLDER, "ADT-FZK-Haus-2005-2006.ifc")),
	PAOLO(new File(TestFileConstants.DATA_FOLDER, "Paolo.ifc")), 
	HAUS_ALT_SOURCE_FILE(new File(TestFileConstants.DATA_FOLDER, "AC9R1-Haus-G-H-Ver2-2x3_ALT.ifc"));

	private final File file;

	TestFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}