package org.bimserver.ifc.file.reader;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.emf.Ifc2x3.impl.Ifc2x3PackageImpl;
import org.bimserver.ifc.file.reader.generated.ParseException;
import org.bimserver.ifc.file.reader.generated.Part21ParserToEmf;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This class reads an IFC file and stores it as a Map (#id, EObject)
 */
public class IfcFileReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcFileReader.class);
	
	public static final File DEFAULT_SCHEMA_FILE = new File((".." + File.separator + "BimServer" + File.separator + "deploy" + File.separator + "shared" + File.separator + "IFC2X3_FINAL.exp"));
	
	public Map<Long, EObject> read(SchemaDefinition schemaDefinition, File ifcFile) throws FileNotFoundException {
//		Logger.disableDefaultOutput();
		long s = System.nanoTime();
		Ifc2x3PackageImpl.init();
		long e = System.nanoTime();
		LOGGER.info("Ifc2x3Package init done in " + ((e - s) / 1000000) + " ms");
		s = System.nanoTime();
		Part21ParserToEmf parser = new Part21ParserToEmf(new FileInputStream(ifcFile));
		
		EObjectMapParser parsingHelper = new EObjectMapParser(schemaDefinition, 10000000);
		parser.init(parsingHelper);
		e = System.nanoTime();
		LOGGER.info("Parser init done in " + ((e - s) / 1000000) + " ms");
		s = System.nanoTime();
		try {
			parser.syntax();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		e = System.nanoTime();
		LOGGER.info("Parsing done in " + ((e - s) / 1000000) + " ms");
		return parsingHelper.getObjects();
	}
}