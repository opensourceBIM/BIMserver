package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.ifc.IfcModel;

public class Query implements QueryInterface {

	private IfcModel model;
	private PrintWriter out;

	@Override
	public void query(IfcModel model, PrintWriter out) {
	}
}