package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestTokenizer {
	private static void readFileName(String input) throws TokenizeException, ParseException {
		Tokenizer tokenizer = new Tokenizer(input);
		tokenizer.zoomIn("(", ")");
		filterComments(tokenizer);
		System.out.println(tokenizer.readSingleQuoted());
		tokenizer.readComma();
		filterComments(tokenizer);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		System.out.println(dateFormatter.parse(tokenizer.readSingleQuoted()));
		tokenizer.readComma();
		filterComments(tokenizer);
		tokenizer.zoomIn("(", ")");
		while (!tokenizer.isEmpty()) {
			System.out.println(tokenizer.readSingleQuoted());
			if (tokenizer.nextIsAComma()) {
				tokenizer.readComma();
			}
		}
		tokenizer.zoomOut();
		tokenizer.readComma();
		filterComments(tokenizer);
		tokenizer.zoomIn("(", ")");
		while (!tokenizer.isEmpty()) {
			System.out.println(tokenizer.readSingleQuoted());
			if (tokenizer.nextIsAComma()) {
				tokenizer.readComma();
			}
		}
		tokenizer.zoomOut();
		tokenizer.readComma();
		filterComments(tokenizer);
		System.out.println(tokenizer.readSingleQuoted());
		tokenizer.readComma();
		filterComments(tokenizer);
		System.out.println(tokenizer.readSingleQuoted());
		tokenizer.readComma();
		filterComments(tokenizer);
		if (tokenizer.nextIsDollar()) {
			System.out.println(tokenizer.readDollar());
		} else {
			System.out.println(tokenizer.readSingleQuoted());
		}
		tokenizer.zoomOut();
		tokenizer.shouldBeFinished();
	}

	private static void filterComments(Tokenizer tokenizer) throws TokenizeException {
		if (tokenizer.startsWith("/*")) {
			tokenizer.zoomIn("/*", "*/");
			tokenizer.readAll();
			tokenizer.zoomOut();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		try {
			readFileName("('\\\\alpha\\macvol\\Projects\\2006\\06006 18 - 40 Mount St\\11.0 CAD\\11.20 Data Exchange\\Sent out\\IFC''s\\090320\\A.BIM.P-090320.ifc','2009-03-20T16:36:54',('Architect'),('Building Designer Office'),'PreProc - EDM 4.5.0033','Windows System','The authorising person')");
			readFileName("(\r\n/* name */ '040123_TF_Teil_Halle_A3',\r\n/* time_stamp */ '2004-01-23T12:53:15+01:00',\r\n/* author */ ('Dayal'),\r\n/* organization */ ('Audi/TUM'),\r\n/* preprocessor_version */ 'ST-DEVELOPER v8',\r\n/* originating_system */ 'WinXP',\r\n/* authorisation */ 'dayal')");
			readFileName("('', '2007-04-10T13:03:07', (''), (''), 'IFC Export', 'Esa.Pt', '')");
			readFileName("('G:\\Users\\NLST\\ArchiCAD\\2x.ifc','2006-02-16T17:26:18',('Architect'),('Building Designer Office'),'PreProc - EDM 4.5.0033','Windows System','The authorising person')");
			readDescription("(('ArchiCAD 11.00 Release 1 generated IFC file.','Build Number of the Ifc 2x3 interface: 63096 (01-09-2008)\\X\\0A'),'2;1')");
			readDescription("(('ArchiCAD 11.00 Release 1 generated IFC file.','Build Number of the Ifc 2x3 interface: 63090 (13-06-2008)\\X\\0A'),'2;1')");
			readDescription("((''), '2;1')");
			readDescription("((), '2;1')");
			readFileName("('Y:\\IFC\\IFC Certification\\IFC2x3 ADT Files\\Ready for IAI\\01-01-03-Clipping-ADT.ifc','2006-12-12T10:07:32',('Autodesk Inc.'),('Autodesk Inc.',''),'AutoCAD Architecture Kiasma Build 17.1.40.0 - 1.0','Microsoft Windows NT 5.1.2600 Service Pack 2','')");
			readFileName("('C:\\documents and settings\\stephj1\\my documents\\briefcases\\ifc-mbomb\\ifc-mbomb_t416\\t-block\\Views\\003-T-Block.dwg','2004-01-26T14:03:27',(''),('Taylor Woodrow'),'IFC-Utility 2x for ADT V. 2, 0, 2, 5   (www.inopso.com) - IFC Toolbox Version 2.x (00/11/07)','Autodesk Architectural Desktop','JS')");
			readFileName("('C:\\IFC\\IFC Certification\\IFC2x3 ADT Files\\Ready for IAI\\00-01-01-BasicSpaces-ADT-fix1.ifc','2006-12-14T10:55:37',('Autodesk Inc.'),('Autodesk Inc.',''),'AutoCAD Architecture Kiasma Build 17.1.40.0 - 1.0','Microsoft Windows NT 5.1.2600 Service Pack 2','')");
			readFileName("('WallIFCexport_situationzelfdeguids.ifc','2013-06-27T20:05:58',(''),(''),'Autodesk Revit 2013','20121003_2115(x64) - Exporter 2.7.0.0 - Alternate UI 1.7.0.0',$)");
			readDescription("(('ArchiCAD 11.00 Release 1 generated IFC file.','Build Number of the Ifc 2x3 interface: 63090 (13-06-2008)\\X\\0A'),'2;1')");
			readFileName("('S:\\[IFC]\\COMPLETE-BUILDINGS\\FZK-MODELS\\Buerogebaeude-Zones\\ArchiCAD-11\\Institute-Var-2\\IFC2x3\\AC11-Institute-Var-2-IFC.ifc','2008-07-03T15:22:43',('Architect'),('Building Designer Office'),'PreProc - EDM 4.5.0033','Windows System','The authorising person')");
		} catch (TokenizeException e) {
			e.printStackTrace();
		}
		try {
			readFileName("('TBlockArchicadDucts',\r\n     '2004-01-22T20:08:03',\r\n          ('sdai-user'),\r\n          ('ANONYMOUS ORGANISATION'),\r\n          'EXPRESS Data Manager version 20030909',   \r\n       $,\r\n          $)");
		} catch (TokenizeException e) {
			// This is supposed to go wrong because of the $ signs
		}
	}

	private static void readDescription(String string) throws TokenizeException {
		Tokenizer tokenizer = new Tokenizer(string);
		tokenizer.zoomIn("(", ")");
		tokenizer.zoomIn("(", ")");
		while (!tokenizer.isEmpty()) {
			System.out.println(tokenizer.readSingleQuoted());
			if (tokenizer.nextIsAComma()) {
				tokenizer.readComma();
			}
		}
		tokenizer.zoomOut();
		tokenizer.readComma();
		System.out.println(tokenizer.readSingleQuoted());
		tokenizer.zoomOut();
		tokenizer.shouldBeFinished();
	}
}