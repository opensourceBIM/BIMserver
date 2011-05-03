package org.bimserver.querycompiler;

import java.io.PrintWriter;

import org.bimserver.ifc.IfcModel;

public interface QueryInterface {
	void query(IfcModel model, PrintWriter out);
}