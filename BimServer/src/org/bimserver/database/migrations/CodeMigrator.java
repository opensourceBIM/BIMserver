package org.bimserver.database.migrations;

import java.io.File;

/**
 * @author Ruben de Laat
 *
 *	Steps:
 *    1. Run this class it's main method, this will generate an ecore file (models/models.ecore) reflecting all available migration steps combined.
 *    2. Open the models/models.genmodel file, right-click on the root node and select "Generate Model Code"
 *    3. Verify there are no compile errors, and fix those first by changing your migration code
 *    4. 
 *
 */

public class CodeMigrator {
	public static void main(String[] args) {
		new CodeMigrator().start();
	}

	private void start() {
		Migrator migrator = new Migrator(null);
		Schema schema = migrator.migrateSchemaTo(2);
		schema.writeToEcore(new File("models/models.ecore"));
	}
}
