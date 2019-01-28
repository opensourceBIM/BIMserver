package org.bimserver.tests;

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

import java.nio.file.Path;

public enum TestFile {
	EXPORT1(TestFileConstants.DATA_FOLDER.resolve("export1.ifc")),
	EXPORT3(TestFileConstants.DATA_FOLDER.resolve("export3.ifc")),
	NIEDRI(TestFileConstants.DATA_FOLDER.resolve("Niedri_org.ifc")),
	MERGE_TEST_SOURCE_FILE(TestFileConstants.DATA_FOLDER.resolve("MergeTest.ifc")), 
	HITOS_SOURCE_FILE(TestFileConstants.DATA_FOLDER.resolve("HITOS_070308.ifc")), 
	HAUS_SOURCE_FILE(TestFileConstants.DATA_FOLDER.resolve("AC9R1-Haus-G-H-Ver2-2x3.ifc")), 
	AC11_XML(TestFileConstants.DATA_FOLDER.resolve("AC11-Institute-Var-2-ifcXML.ifcxml")), 
	SIX_SPACES_XML(TestFileConstants.DATA_FOLDER.resolve("SixSpaces.ifcxml")), 
	RIOLERING_TEST(TestFileConstants.DATA_FOLDER.resolve("RioleringTestArkey.ifc")), 
	EMPTY_TEST(TestFileConstants.DATA_FOLDER.resolve("EmptyTest.ifc")), 
	WALL_ONLY(TestFileConstants.DATA_FOLDER.resolve("WallOnly.ifc")),
	WALL_ONLY_ADDED_SPACE(TestFileConstants.DATA_FOLDER.resolve("WallOnlyAddedSpace.ifc")),
	AC11(TestFileConstants.DATA_FOLDER.resolve("AC11-Institute-Var-2-IFC.ifc")), 
	REVIT_QUANTITIES(TestFileConstants.DATA_FOLDER.resolve("revit_quantities.ifc")), 
	BATHROOM(TestFileConstants.DATA_FOLDER.resolve("BathroomWindow.ifc")),
	JASMIN(TestFileConstants.DATA_FOLDER.resolve("AC90R1-Jasmin-Sun-105-2x3.ifc")),
	ADTHAUS(TestFileConstants.DATA_FOLDER.resolve("ADT-FZK-Haus-2005-2006.ifc")),
	PAOLO(TestFileConstants.DATA_FOLDER.resolve("Paolo.ifc")), 
	HAUS_ALT_SOURCE_FILE(TestFileConstants.DATA_FOLDER.resolve("AC9R1-Haus-G-H-Ver2-2x3_ALT.ifc"));

	private final Path file;

	TestFile(Path file) {
		this.file = file;
	}

	public Path getFile() {
		return file;
	}
}