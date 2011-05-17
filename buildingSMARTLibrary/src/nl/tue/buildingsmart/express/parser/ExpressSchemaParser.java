package nl.tue.buildingsmart.express.parser;

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
			// myErr.close();
			walker.schema.constructHirarchyMap();
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
		// TODO Auto-generated method stub
		// EntityDefinition Entities = new EntityDefinition("test");
		// for (int i=0;i<100000;i++){
		// InverseAttribute a = new InverseAttribute(new
		// String("test"+i),Entities);
		// Entities.addAttribute(a);
		// }
		// for (int j=0;j<100;j++){
		// java.util.Random r = new java.util.Random();
		// Attribute d = Entities.getAttributes().get(r.nextInt(100000));
		// }
		// System.out.print("ready");

		String usage = "lasdfasdfasdf";
		EasyParser parser;
		Express2DictWalker walker;

		File file;
		FileOutputStream out;
		String commonSchemaFile = null, fileIn = null, fileOut = null;
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		int c;

		/* arguments management */
		Getopt g = new Getopt("Express2Dict", argv, "o:s:");
		while ((c = g.getopt()) != -1)
			switch (c) {
			case 'o':
				fileOut = g.getOptarg();
				break;
			case 's':
				commonSchemaFile = g.getOptarg();
				break;
			case '?':
				System.err.println(usage);
				System.exit(1);
				break;
			default:
				break;
			}
		try {
			fileIn = argv[g.getOptind()];
		} catch (Exception e) {
			System.err.println("E2OWL: Input file not specified");
			System.err.println(usage);
			System.exit(1);
		}
		file = new File(fileIn);
		if (!file.canRead()) {
			System.err.println("E2OWL: Unable to read file " + fileIn);
			System.exit(1);
		}
		try {
			// PrintStream stdErrOld= System.err;
			// PrintStream stdOutOld= System.out;
			// FileOutputStream log = new FileOutputStream("parser.log");
			// PrintStream myErr = new PrintStream(log);
			// System.setErr(myErr);
			// System.setOut(myErr);

			parser = new EasyParser(fileIn);
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
			// System.setErr(stdErrOld);
			// System.setOut(stdOutOld);
			// myErr.close();
			SchemaDefinition schema = walker.getSchema();
			Iterator iter = schema.getEntities().iterator();
			while (iter.hasNext()) {
				EntityDefinition ent = (EntityDefinition) iter.next();
				LOGGER.info(ent.getName());
				Iterator at = ent.getAttributes().iterator();
				while (at.hasNext()) {
					Attribute attr = (Attribute) at.next();
					System.out.print(ent.getName() + ":" + attr.getName());
					if (attr instanceof ExplicitAttribute) {
						BaseType bt = (BaseType) ((ExplicitAttribute) attr).getDomain();
						if (bt instanceof NamedType) {
							if (bt != null)
								System.out.print(" is-a " + ((NamedType) bt).getName());
						} else if (bt instanceof AggregationType) {
							if (bt != null && ((AggregationType) bt).getElement_type() != null)
								System.out.print(" is-a " + ((AggregationType) bt).getElement_type().getClass());
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

			Iterator ti = schema.getTypes().iterator();
			while (ti.hasNext()) {
				DefinedType type = (DefinedType) ti.next();
				UnderlyingType ut = type.getDomain();
				if (ut != null)
					LOGGER.info(type.getName() + ":" + ut.getClass());
				else if (type instanceof SelectType) {
					LOGGER.info(type.getName() + ((SelectType) type).getSelections().toString());
				} else if (type instanceof EnumerationType) {
					LOGGER.info(type.getName() + ((EnumerationType) type).getElements().toString());
				}

				// else if (type instanceof SimpleType){
				// LOGGER.info(type.getName()+":"+type.getClass());
				// }
				else if (ut == null && !(type instanceof SelectType))

					LOGGER.error(type.getName() + " has no underlying_type");

			}

			// Print the resulting tree out in LISP notation
			// LOGGER.info(t.toStringTree());

			// AST t = walker.getAST();
			// LOGGER.info(t.toStringTree());
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("execution time: " + getStringTime(System.currentTimeMillis() - startTime));
		// String fileName = "ifc2_2.owl";
		// try{ Collection errors = new ArrayList();
		// owlModel.save(new FileOutputStream(fileName),
		// FileUtils.langXMLAbbrev,errors);
		// LOGGER.info("File saved with " + errors.size() + " errors.");
		// LOGGER.info("execution time: "+getStringTime(System.currentTimeMillis()-startTime));
		// } catch (java.io.IOException e) {
		//	LOGGER.error("", e);
		// }

	}

	private static final String getStringTime(long millis) {
		int seconds = (int) (millis / 1000);
		int minutes = (seconds / 60);
		int hours = (minutes / 60);
		minutes -= hours * 60;
		seconds -= (hours * 3600) + (minutes * 60);
		return (((hours < 10) ? "0" + hours : "" + hours) + ":" + ((minutes < 10) ? "0" + minutes : "" + minutes) + ":" + ((seconds < 10) ? "0" + seconds : "" + seconds));
	}

}
