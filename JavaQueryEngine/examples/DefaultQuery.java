package org.bimserver.jqep;

import java.io.PrintWriter;

import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.jqep.*;

public class Query implements QueryInterface {

	@Override
	public void query(IfcModelInterface source, Reporter reporter, ModelHelper modelHelper) {
		reporter.info("Running default example");
	}
}