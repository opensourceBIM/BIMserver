package nl.tue.buildingsmart.express.population.test;
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
			/*byte[] contents= new byte[100];
			try {
				
				input.read(contents);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOGGER.error("", e);
			}*/
			model = new ModelPopulation (input);
			model.setSchemaFile(new File("data" + File.separator + "IFC2X3_FINAL.exp"));
			model.load();
			
			System.out.println(model.getInstancesOfType("IfcWall").size());
			
			System.out.println("ready");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);

		}
	}
}
