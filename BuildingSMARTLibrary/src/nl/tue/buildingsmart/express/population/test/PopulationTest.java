package nl.tue.buildingsmart.express.population.test;

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
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.express.population.ModelPopulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopulationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulationTest.class);
	private ModelPopulation model;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PopulationTest().start(new File(args[0]));
	}

	private void start(File file) {
		try {
			FileInputStream input = new FileInputStream(file);
			/*
			 * byte[] contents= new byte[100]; try {
			 * 
			 * input.read(contents); } catch (IOException e) { // TODO
			 * Auto-generated catch block LOGGER.error("", e); }
			 */
			model = new ModelPopulation(input);
			model.setSchemaFile(new File("data" + File.separator + "IFC2X3_TC1.exp"));
			model.load();

			System.out.println(model.getInstancesOfType("IfcWall").size());

			System.out.println("ready");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);

		}
	}
}
