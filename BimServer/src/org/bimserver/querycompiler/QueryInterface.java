package org.bimserver.querycompiler;

import java.io.PrintWriter;

import org.bimserver.ifc.database.IfcDatabase;

public interface QueryInterface {
	void query(IfcDatabase model, PrintWriter out);
}