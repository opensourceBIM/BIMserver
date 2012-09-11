package org.bimserver.jqep;

import java.io.PrintWriter;

import org.bimserver.plugins.QueryEngineHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IfcModelInterface;

public class Query implements QueryInterface {

	@Override
	public void query(IfcModelInterface source, IfcModelInterface dest, Reporter reporter, QueryEngineHelper queryEngineHelper) {
		reporter.info("Running default example");
	}
}