package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.ifc.database.IfcDatabase;

public class Query implements QueryInterface {

	private IfcDatabase<Long> model;
	private PrintWriter out;

	@Override
	public void query(IfcDatabase<Long> model, PrintWriter out) {
	}
}