package org.bimserver.demoplugins.service;
import java.io.StringWriter;
import java.util.Date;

import org.bimserver.demoplugins.service.planner.EventLog;
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
import org.bimserver.models.ifc2x3tc1.IfcDateAndTime;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProcess;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssigns;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsTasks;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcScheduleTimeControl;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

import au.com.bytecode.opencsv.CSVWriter;

public class EventLogService extends ServicePlugin {
	private static final String NAMESPACE = "http://bimserver.org/eventlog";
	private static final Logger LOGGER = LoggerFactory.getLogger(EventLogService.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Eventlog as CSV";
	}

	@Override
	public String getDefaultName() {
		return "Eventlog as CSV";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Eventlog as CSV";
	}

	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalService, PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalService.getOid());
		serviceDescriptor.setName("Eventlog as CSV");
		serviceDescriptor.setDescription("Eventlog as CSV");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteExtendedData(NAMESPACE);
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Eventlog as CSV");
					SLongActionState state = new SLongActionState();
					state.setTitle("Eventlog as CSV");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
					IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);
					
					try {
						SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(NAMESPACE);
						
						EventLog eventLog = new EventLog(model);
						
						String csvString = eventLog.toCsvString();
						
						addExtendedData(csvString.getBytes(Charsets.UTF_8), "eventlog.csv", "Eventlog", bimServerClientInterface, roid, extendedDataSchemaByNamespace);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Eventlog as CSV");
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
					file.setMime("text/csv");

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
