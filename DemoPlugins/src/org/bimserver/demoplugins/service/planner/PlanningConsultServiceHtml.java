package org.bimserver.demoplugins.service.planner;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.services.BimServerClientInterface;

import com.google.common.base.Charsets;

public class PlanningConsultServiceHtml extends AbstractPlanningConsultService {
	
	private static final String NAMESPACE = "http://bimserver.org/planningconsult";

	public PlanningConsultServiceHtml() {
		super("Planning Consult HTML", "Planning Consult HTML", NAMESPACE);
	}
	
	@Override
	protected void createExtendedData(Planner planner, IfcModelInterface model, BimServerClientInterface bimServerClientInterface, long roid) {
		Map<String, PlanningAdvice> suggestedPlanningsPerMaterial = planner.getSuggestedPlanningsPerMaterial(model);

		StringBuilder recognized = new StringBuilder();
		recognized.append("<h1>Planning Consult Results</h1>");

		StringBuilder unrecognized = null;

		for (String material : suggestedPlanningsPerMaterial.keySet()) {
			PlanningAdvice planningAdvice = suggestedPlanningsPerMaterial.get(material);
			if (planningAdvice.getDatabaseCount() == 0) {
				if (unrecognized == null) {
					unrecognized = new StringBuilder();
					unrecognized.append("<p>The following elements are not recognized in the database: </p><table class=\"table\"><thead><tr><th>Product type</th><th>Amount of elements in model</th></tr></thead><tbody>");
				}
				unrecognized.append("<tr><td>" + material + "</td><td>" + planningAdvice.getModelCount() + "</td></tr>");
			} else {
				recognized.append("<h1>" + material + "</h1>");
				recognized.append("<p>In the model are found " + planningAdvice.getModelCount() + " elements of this type of product.</p>");
				recognized.append("<h2>Planning advice</h2>");
				recognized.append("<p>Amount of elements in the database: " + planningAdvice.getDatabaseCount() + "</p>");
				recognized.append("<p>In the planningsdatabase the following process variants are found</p>");

				int counter = 1;
				for (Planning planning : planningAdvice.getUniquePlannings()) {
					recognized.append("<h3>Variant " + counter + ": " + planningAdvice.getPercentage(planning) + " % of the elements from this product type are planned according to these steps: </h3>");
					recognized.append("<table class=\"table\"><thead><tr><th>Task number</th><th>Task name</th><th>Percent on time</th><th>Percent too late</th><th>Percent unknown</th></tr></thead><tbody>");
					int taskCounter = 1;
					for (Task task : planning.getTasks()) {
						recognized.append("<tr>");
						recognized.append("<td>" + taskCounter + "</td>");
						recognized.append("<td>" + task.getCode() + " " + task.getDescription() + "</td>");
						recognized.append("<td>" + task.getPercentOnTime() + "%</td>");
						recognized.append("<td>" + task.getPercentTooLate() + "%</td>");
						recognized.append("<td>" + task.getPercentUnknown() + "%</td>");
						recognized.append("</tr>");

						taskCounter++;
					}
					recognized.append("</tbody></table>");
					counter++;
				}
			}
		}

		if (unrecognized != null) {
			unrecognized.append("</tbody></table>");
		}

		addExtendedData(((unrecognized == null ? "" : unrecognized.toString()) + recognized.toString()).getBytes(Charsets.UTF_8), "planning.html", "Planning Consult Results (HTML)", "text/html", bimServerClientInterface, roid);
	}
}