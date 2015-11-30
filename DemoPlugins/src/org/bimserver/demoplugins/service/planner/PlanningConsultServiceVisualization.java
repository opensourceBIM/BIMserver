package org.bimserver.demoplugins.service.planner;

import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
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
		visNode.put("name", "Clashes");
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
		orangeSelector.set("selector", orangeSelector);
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
		greenChange.set("effect", orangeEffect);
		ObjectNode redEffect = objectMapper.createObjectNode();
		greenChange.set("effect", redEffect);
		
		ObjectNode green = objectMapper.createObjectNode();
		greenEffect.set("color", green);
		green.put("r", 1);
		green.put("g", 0);
		green.put("b", 0);
		green.put("a", 0.7f);

		ObjectNode orange = objectMapper.createObjectNode();
		orangeEffect.set("color", orange);
		orange.put("r", 1);
		orange.put("g", 0);
		orange.put("b", 0);
		orange.put("a", 0.7f);

		ObjectNode red = objectMapper.createObjectNode();
		redEffect.set("color", red);
		red.put("r", 1);
		red.put("g", 0);
		red.put("b", 0);
		red.put("a", 0.7f);

		for (String material : suggestedPlanningsPerMaterial.keySet()) {
			PlanningAdvice planningAdvice = suggestedPlanningsPerMaterial.get(material);
			for (Planning planning : planningAdvice.getUniquePlannings()) {
				for (Task task : planning.getTasks()) {
					int percentOnTime = task.getPercentOnTime();
					if (percentOnTime >= 99) {
						
					} else if (percentOnTime > 50) {
						
					} else {
						
					}
				}
			}
		}		
		
		addExtendedData(visNode.toString().getBytes(Charsets.UTF_8), "visualizationinfo.json", "Planning Consult Results", "application/json", bimServerClientInterface, roid);
	}
}