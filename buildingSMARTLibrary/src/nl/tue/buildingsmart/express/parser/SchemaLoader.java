package nl.tue.buildingsmart.express.parser;
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
	
	public SchemaLoader (String fileName){
		try {
			EasyParser parser = new EasyParser(fileName);
			Express2DictWalker walker = new Express2DictWalker();
			// walker.methods.setModel(owlModel);

			/* result = */
			CommonAST t = parser.parse();
			PrintStream stdErrOld= System.err;
			PrintStream stdOutOld= System.out;
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
		}
		catch (Exception e){
			LOGGER.error("", e);
		}
	}
	public SchemaDefinition getSchema(){
		return schema;
	}
	
}
