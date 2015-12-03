package org.bimserver.demoplugins.service.planner;

import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.services.BimServerClientInterface;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;

public class PlanningConsultServiceVisualization extends AbstractPlanningConsultService {

	private static final String NAMESPACE = "http://bimserver.org/3dvisualizationeffects";

	public PlanningConsultServiceVisualization() {
		super("Planning Consult Visualization", "Planning Consult Visualization", NAMESPACE);
	}

	@Override
	protected void createExtendedData(Planner planner, IfcModelInterface model, BimServerClientInterface bimServerClientInterface, long roid) {
		Map<String, PlanningAdvice> suggestedPlanningsPerMaterial = planner.getSuggestedPlanningsPerMaterial(model);

		ObjectMapper objectMapper = new ObjectMapper();
		
		ObjectNode visNode = objectMapper.createObjectNode();
		visNode.put("name", "Estimated on time");
		ArrayNode changes = objectMapper.createArrayNode();
		visNode.set("changes", changes);
		
		ObjectNode greenChange = objectMapper.createObjectNode();
		changes.add(greenChange);
		ObjectNode greenSelector = objectMapper.createObjectNode();
		greenChange.set("selector", greenSelector);
		ArrayNode greenGuids = objectMapper.createArrayNode();
		greenSelector.set("guids", greenGuids);

		ObjectNode orangeChange = objectMapper.createObjectNode();
		changes.add(orangeChange);
		ObjectNode orangeSelector = objectMapper.createObjectNode();
		orangeChange.set("selector", orangeSelector);
		ArrayNode orangeGuids = objectMapper.createArrayNode();
		orangeSelector.set("guids", orangeGuids);

		ObjectNode redChange = objectMapper.createObjectNode();
		changes.add(redChange);
		ObjectNode redSelector = objectMapper.createObjectNode();
		redChange.set("selector", redSelector);
		ArrayNode redGuids = objectMapper.createArrayNode();
		redSelector.set("guids", redGuids);

		ObjectNode greenEffect = objectMapper.createObjectNode();
		greenChange.set("effect", greenEffect);
		ObjectNode orangeEffect = objectMapper.createObjectNode();
		orangeChange.set("effect", orangeEffect);
		ObjectNode redEffect = objectMapper.createObjectNode();
		redChange.set("effect", redEffect);
		
		ObjectNode green = objectMapper.createObjectNode();
		greenEffect.set("color", green);
		green.put("r", 0);
		green.put("g", 1);
		green.put("b", 0);
		green.put("a", 1f);

		ObjectNode orange = objectMapper.createObjectNode();
		orangeEffect.set("color", orange);
		orange.put("r", 1);
		orange.put("g", 0.647);
		orange.put("b", 0);
		orange.put("a", 1f);

		ObjectNode red = objectMapper.createObjectNode();
		redEffect.set("color", red);
		red.put("r", 1);
		red.put("g", 0);
		red.put("b", 0);
		red.put("a", 1f);

		for (String material : suggestedPlanningsPerMaterial.keySet()) {
			PlanningAdvice planningAdvice = suggestedPlanningsPerMaterial.get(material);
			for (Planning planning : planningAdvice.getUniquePlannings()) {
				int totalTasks = 0;
				int totalPercentage = 0;
				for (Task task : planning.getTasks()) {
					totalTasks++;
					totalPercentage += task.getPercentOnTime();
				}
				int percentageOnTime = totalPercentage / totalTasks;
				for (IfcProduct ifcProduct : planningAdvice.getRelatedProducts()) {
					if (percentageOnTime >= 99) {
						greenGuids.add(ifcProduct.getGlobalId());
					} else if (percentageOnTime > 50) {
						orangeGuids.add(ifcProduct.getGlobalId());
					} else {
						redGuids.add(ifcProduct.getGlobalId());
					}
				}
			}
		}		
		
		addExtendedData(visNode.toString().getBytes(Charsets.UTF_8), "visualizationinfo.json", "Planning Consult Results (JSON Visualization)", "application/json", bimServerClientInterface, roid);
	}
}