package org.bimserver.database.migrations;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		new Test().start();
	}

	private void start() {
		Schema schema = new Schema();
		
		Step0000 step0001 = new Step0000();
		step0001.migrate(schema);
		
		schema.writeToEcore(new File("model.ecore"));
	}
}
