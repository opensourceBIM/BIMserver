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

import gnu.getopt.Getopt;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Iterator;

import net.sourceforge.osexpress.parser.EasyParser;

import org.bimserver.plugins.schema.AggregationType;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.BaseType;
import org.bimserver.plugins.schema.DefinedType;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.EnumerationType;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.NamedType;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SelectType;
import org.bimserver.plugins.schema.UnderlyingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.CommonAST;

import com.google.common.base.Charsets;

/**
 * @author bwjakob
 * 
 */
@SuppressWarnings("all")
public class ExpressSchemaParser {

	/**
	 * @param args
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpressSchemaParser.class);
	EasyParser parser;
	Express2DictWalker walker;
	private InputStream inputStream;

	public ExpressSchemaParser(File file) {
		try {
			this.inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	public ExpressSchemaParser(URL url) {
		try {
			this.inputStream = url.openConnection().getInputStream();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void parse() {
		ByteArrayOutputStream log = new ByteArrayOutputStream();
		try {
			PrintStream stdErrOld = System.err;
			PrintStream stdOutOld = System.out;
			PrintStream myErr = new PrintStream(log);
			System.setErr(myErr);
			System.setOut(myErr);
			parser = new EasyParser(new BufferedInputStream(inputStream));

			walker = new Express2DictWalker();
			// walker.methods.setModel(owlModel);

			/* result = */
			CommonAST t = parser.parse();

			walker.setPass(1);
			walker.syntax(t);
			walker.setPass(2);

			walker.syntax_pass2(t);
			walker.setPass(3);
			walker.syntax_pass2(t);
			walker.setPass(4);
			walker.syntax_pass2(t);
			System.setErr(stdErrOld);
			System.setOut(stdOutOld);
			walker.getSchema().constructHirarchyMap();
		} catch (Exception e) {
			LOGGER.error("", e);
			LOGGER.error(new String(log.toByteArray(), Charsets.UTF_8));
		}
	}

	public SchemaDefinition getSchema() {
		if (walker != null) {
			return walker.getSchema();
		}
		return null;
	}

	public static void main(String[] argv) {
		EasyParser parser;
		Express2DictWalker walker;

		FileOutputStream out;
		String commonSchemaFile = null, fileIn = null, fileOut = null;
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		int currentCommandLineOption;

		/* arguments management */
		Getopt g = new Getopt("Express2Dict", argv, "o:s:");
		while ((currentCommandLineOption = g.getopt()) != -1) {
			switch (currentCommandLineOption) {
			case 'o':
				fileOut = g.getOptarg();
				break;
			case 's':
				commonSchemaFile = g.getOptarg();
				break;
			case '?':
				System.err.println("exiting");
				System.exit(1);
				break;
			default:
				break;
			}
		}

		fileIn = getFileIn(argv, g);
		checkInputFile(fileIn);

		try {
			parser = new EasyParser(fileIn);
			walker = new Express2DictWalker();

			/* result = */
			CommonAST parsedTree = parser.parse();

			walker.setPass(1);
			walker.syntax(parsedTree);

			walker.setPass(2);
			walker.syntax_pass2(parsedTree);

			walker.setPass(3);
			walker.syntax_pass2(parsedTree);

			SchemaDefinition schema = walker.getSchema();
			printSchemaToConsole(schema);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("execution time: " + getStringTime(System.currentTimeMillis() - startTime));
	}

	private static String getFileIn(String[] argv, Getopt g) {
		try {
			return argv[g.getOptind()];

		} catch (Exception e) {
			System.err.println("E2OWL: Input file not specified");
			System.exit(1);
		}
		System.err.println("E2OWL: Error in parsing input file");
		System.exit(1);

		return null;
	}

	private static void checkInputFile(String fileIn) {
		File file = new File(fileIn);
		if (!file.canRead()) {
			System.err.println("E2OWL: Unable to read file " + fileIn);
			System.exit(1);
		}
	}

	private static void printSchemaToConsole(SchemaDefinition schema) {
		printEntities(schema);

		printTypes(schema);
	}

	private static void printEntities(SchemaDefinition schema) {
		Iterator entityIterator = schema.getEntities().iterator();
		while (entityIterator.hasNext()) {
			EntityDefinition ent = (EntityDefinition) entityIterator.next();
			LOGGER.info(ent.getName());
			Iterator at = ent.getAttributes().iterator();
			while (at.hasNext()) {
				Attribute attr = (Attribute) at.next();
				System.out.print(ent.getName() + ":" + attr.getName());
				if (attr instanceof ExplicitAttribute) {
					BaseType bt = (BaseType) ((ExplicitAttribute) attr).getDomain();
					if (bt instanceof NamedType) {
						if (bt != null) {
							System.out.print(" is-a " + ((NamedType) bt).getName());
						}
					} else if (bt instanceof AggregationType) {
						if (bt != null && ((AggregationType) bt).getElement_type() != null) {
							System.out.print(" is-a " + ((AggregationType) bt).getElement_type().getClass());
						}
					}

				}
				if (attr instanceof InverseAttribute) {
					InverseAttribute inv = (InverseAttribute) attr;
					EntityDefinition forEnt = inv.getDomain();
					ExplicitAttribute invertedAttr = inv.getInverted_attr();
					System.out.print(inv.getName() + " inverse of ");
					System.out.print(invertedAttr.getName() + " for " + forEnt.getName());

				}
				LOGGER.info("");
			}
		}
	}

	private static void printTypes(SchemaDefinition schema) {
		Iterator typeIterator = schema.getTypes().iterator();
		while (typeIterator.hasNext()) {
			DefinedType type = (DefinedType) typeIterator.next();
			UnderlyingType ut = type.getDomain();
			if (ut != null)
				LOGGER.info(type.getName() + ":" + ut.getClass());
			else if (type instanceof SelectType) {
				LOGGER.info(type.getName() + ((SelectType) type).getSelections().toString());
			} else if (type instanceof EnumerationType) {
				LOGGER.info(type.getName() + ((EnumerationType) type).getElements().toString());
			} else if (ut == null && !(type instanceof SelectType))
				LOGGER.error(type.getName() + " has no underlying_type");
		}
	}

	private static final String getStringTime(long millis) {
		int seconds = (int) (millis / 1000);
		int minutes = (seconds / 60);
		int hours = (minutes / 60);
		minutes -= hours * 60;
		seconds -= (hours * 3600) + (minutes * 60);
		return (((hours < 10) ? "0" + hours : "" + hours) + ":" + ((minutes < 10) ? "0" + minutes : "" + minutes) + ":" + ((seconds < 10) ? "0" + seconds : "" + seconds));
	}

	public void close() {
		try {
			inputStream.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}