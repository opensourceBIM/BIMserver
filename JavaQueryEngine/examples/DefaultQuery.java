package org.bimserver.jqep;

import java.io.PrintWriter;
import org.bimserver.plugins.serializers.IfcModelInterface;

public class Query implements QueryInterface {

	@Override
	public void query(IfcModelInterface model, PrintWriter out) {
		out.println("Running default example");
	}
}