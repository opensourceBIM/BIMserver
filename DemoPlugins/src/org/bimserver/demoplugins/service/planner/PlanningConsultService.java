package org.bimserver.demoplugins.service.planner;
import java.util.Date;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.fusesource.hawtbuf.ByteArrayInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class PlanningConsultService extends ServicePlugin {
	private static final String NAMESPACE = "http://bimserver.org/planningconsult";
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanningConsultService.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Planning Consult";
	}

	@Override
	public String getDefaultName() {
		return "Planning Consult";
	}

	@Override
	public String getVersion() {
		return "1.0";
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
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Planning Consult";
	}

	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalService, PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalService.getOid());
		serviceDescriptor.setName("Planning Consult");
		serviceDescriptor.setDescription("Planning Consult");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteExtendedData(NAMESPACE);
		
		byte[] eventLogBytes = pluginConfiguration.getByteArray("EventLog");
		final Planner planner = new Planner();
		if (eventLogBytes != null) {
			planner.feedTrainingData(new EventLog(new ByteArrayInputStream(eventLogBytes)));
			planner.analyze();
		}
		
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Planning Consult");
					SLongActionState state = new SLongActionState();
					state.setTitle("Planning Consult");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
					IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);
					
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
					
					SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(NAMESPACE);
					
					addExtendedData(((unrecognized == null ? "" : unrecognized.toString()) + recognized.toString()).getBytes(Charsets.UTF_8), "planning.html", "Planning", bimServerClientInterface, roid, extendedDataSchemaByNamespace);
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Planning Consult");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				} catch (BimServerClientException e) {
					LOGGER.error("", e);
				}
			}

			private void addExtendedData(byte[] data, String filename, String title, BimServerClientInterface bimServerClientInterface, long roid, SExtendedDataSchema extendedDataSchemaByNamespace) {
				SFile file = new SFile();

				SExtendedData extendedData = new SExtendedData();
				extendedData.setTitle(title);
				file.setFilename(filename);
				extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
				try {
					file.setData(data);
					file.setMime("text/html");

					long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
					extendedData.setFileId(fileId);

					bimServerClientInterface.getBimsie1ServiceInterface().addExtendedDataToRevision(roid, extendedData);
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
	}
	
	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
	}
}