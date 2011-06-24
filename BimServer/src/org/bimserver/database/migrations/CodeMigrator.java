package org.bimserver.database.migrations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.querycompiler.VirtualFile;
import org.bimserver.tools.generators.DataObjectGenerator;
import org.bimserver.tools.generators.ProtocolBuffersGenerator;
import org.bimserver.tools.generators.ServiceGenerator;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ruben de Laat
 *
 *	Steps:
 *    1. Add a new migration (for example create the class Step0005 in org.bimserver.database.migrations.steps)
 *	  2. Change the TARGET_VERSION to the same number
 *    3. Run this class it's main method, this will generate an ecore file (models/models.ecore) reflecting all available migration steps combined.
 *    4. Open the models/models.genmodel file, right-click on the root node and select "Generate Model Code"
 *    5. Verify there are no compile errors, and fix those first by changing your migration code
 *    6. Generate the S-classes: Run org.bimserver.tools.generators.ServiceGenerator
 *    7. Generate the Protocol Buffers file and classes: Run org.bimserver.tools.generators.ProtocolBuffersGenerator
 *
 */

public class CodeMigrator {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeMigrator.class);
	
	public static void main(String[] args) {
		new CodeMigrator().start();
	}

	private void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		LOGGER.info("Starting code migrator...");
		Migrator migrator = new Migrator(null);
		int latestVersion = migrator.getLatestVersion();
		LOGGER.info("Migrating to version " + latestVersion);
		Schema schema = migrator.migrateSchemaTo(latestVersion);
		schema.writeToEcore(new File("models/models.ecore"));
		LOGGER.info("Model migrated to version " + latestVersion);

		LOGGER.info("Choose \"auto\" or \"manual\"");
		try {
			String type = reader.readLine();
			if (type.equalsIgnoreCase("auto")) {
				LOGGER.info("Generating EMF classes...");
				DataObjectGenerator dataObjectGenerator = new DataObjectGenerator(schema);
				VirtualFile basedir = new VirtualFile(null, null);
				VirtualFile generate = dataObjectGenerator.generate(basedir);
				generate.dumpToDir(new File("../Store/generated"));
				LOGGER.info("EMF classes successfully generated");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("Generating ServiceInterface objects...");
		ServiceGenerator serviceGenerator = new ServiceGenerator();
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EPackage ePackage : schema.getEPackages()) {
			if (!ePackage.getName().equals("ifc2x3")) {
				ePackages.add(ePackage);
			}
		}
		serviceGenerator.generateDataObjects(ePackages);
		LOGGER.info("ServiceInterface objects successfully generated");
		
		LOGGER.info("Generating protocol buffers file and classes...");
		ProtocolBuffersGenerator protocolBuffersGenerator = new ProtocolBuffersGenerator();
		protocolBuffersGenerator.start();
		LOGGER.info("Protocol buffers file and classes generated");
		LOGGER.info("");
		LOGGER.info("Migration successfull");
	}
}
