package nl.tue.buildingsmart.express.parser;

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

import java.io.FileOutputStream;
import java.io.PrintStream;

import net.sourceforge.osexpress.parser.EasyParser;

import org.bimserver.plugins.schema.SchemaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.CommonAST;

public class SchemaLoader {
	private SchemaDefinition schema = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaLoader.class);

	public SchemaLoader(String fileName) {
		try {
			EasyParser parser = new EasyParser(fileName);
			Express2DictWalker walker = new Express2DictWalker();
			// walker.methods.setModel(owlModel);

			/* result = */
			CommonAST t = parser.parse();
			PrintStream stdErrOld = System.err;
			PrintStream stdOutOld = System.out;
			FileOutputStream log = new FileOutputStream("parser.log");
			PrintStream myErr = new PrintStream(log);
			System.setErr(myErr);
			System.setOut(myErr);
			walker.setPass(1);
			walker.syntax(t);
			walker.setPass(2);

			walker.syntax_pass2(t);
			walker.setPass(3);
			walker.syntax_pass2(t);

			schema = walker.getSchema();
			schema.constructHirarchyMap();
			System.setErr(stdErrOld);
			System.setOut(stdOutOld);
			myErr.close();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	public SchemaDefinition getSchema() {
		return schema;
	}

}
