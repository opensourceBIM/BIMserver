package org.bimserver.demoplugins.service.planner;
import java.io.ByteArrayInputStream;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import com.google.common.base.Charsets;

public class PlanningConsultService extends AbstractAddExtendedDataService {
	
	private static final String NAMESPACE = "http://bimserver.org/planningconsult";
	private Planner planner;

	public PlanningConsultService() {
		super("Planning Consult", "Planning Consult", NAMESPACE);
	}
	
	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		
		PrimitiveDefinition typeDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		typeDefinition.setType(PrimitiveEnum.BYTE_ARRAY);
		
		ParameterDefinition parameter = StoreFactory.eINSTANCE.createParameterDefinition();
		parameter.setName("EventLog");
		parameter.setDescription("Upload an eventlog here that will be used to come up with a planning advice");
		parameter.setType(typeDefinition);
		
		objectDefinition.getParameters().add(parameter);
		return objectDefinition;
	}
	
	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException, PublicInterfaceNotFoundException, BimServerClientException {
		SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
		IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);

		byte[] eventLogBytes = runningService.getPluginConfiguration().getByteArray("EventLog");
		planner = new Planner();
		if (eventLogBytes != null) {
			planner.feedTrainingData(new EventLog(new ByteArrayInputStream(eventLogBytes)));
			planner.analyze();
		}
		
		Map<String, PlanningAdvice> suggestedPlanningsPerMaterial = planner.getSuggestedPlanningsPerMaterial(model);
		
		StringBuilder recognized = new StringBuilder();
		
		StringBuilder unrecognized = null;
		
		for (String material: suggestedPlanningsPerMaterial.keySet()) {
			PlanningAdvice planningAdvice = suggestedPlanningsPerMaterial.get(material);
			if (planningAdvice.getDatabaseCount() == 0) {
				if (unrecognized == null) {
					unrecognized = new StringBuilder();
					unrecognized.append("<p>The following elements are not recognized in the database: </p><table><thead><tr><th>Product type</th><th>Amount of elements in model</th></tr></thead><tbody>");
				}
				unrecognized.append("<tr><td>" + material + "</td><td>0</td></tr>");
			} else {
				recognized.append("<h1>" + material + "</h1>");
				recognized.append("<p>In the model are found " + planningAdvice.getModelCount() + " elements of this type of product.</p>");
				recognized.append("<h2>Planning advice</h2>");
				recognized.append("<p>Amount of elements in the database: " + planningAdvice.getDatabaseCount() + "</p>");
				recognized.append("<p>In the planningsdatabase the following process variants are found</p>");

				int counter = 1;
				for (Planning planning : planningAdvice.getUniquePlannings()) {
					recognized.append("<h3>Variant " + counter + ": " + planningAdvice.getPercentage(planning) + " % of the elements from this product type are planned according to these steps: </h3>");
					recognized.append("<ol>");
					for (Task task : planning.getTasks()) {
						recognized.append("<li>" + task.getCode() + " - " + task.getDescription() + "</li>");
					}
					recognized.append("</ol>");
					counter++;
				}
			}
		}
		
		if (unrecognized != null) {
			unrecognized.append("</tbody></table>");
		}
		
		addExtendedData(((unrecognized == null ? "" : unrecognized.toString()) + recognized.toString()).getBytes(Charsets.UTF_8), "planning.html", "Planning", "text/html", bimServerClientInterface, roid);		
	}
}