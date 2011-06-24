package org.bimserver.querycompiler;

import java.io.PrintWriter;

import org.bimserver.plugins.serializers.IfcModelInterface;

public interface QueryInterface {
	void query(IfcModelInterface model, PrintWriter out);
}