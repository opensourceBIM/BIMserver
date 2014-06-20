package org.bimserver.demoplugins.service;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement2D;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExploderServicePlugin extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExploderServicePlugin.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Exploder";
	}

	@Override
	public String getDefaultName() {
		return "Exploder";
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
		return "Exploder";
	}

	@Override
	public void register(PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Exploder");
		serviceDescriptor.setDescription("Exploder");
		serviceDescriptor.setWriteRevision(true);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Exploder");

					SLongActionState state = new SLongActionState();
					state.setTitle("Exploder");
					state.setState(SActionState.STARTED);
					state.setProgress(0);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					SProject projectByPoid = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
					
					IfcModelInterface model = bimServerClientInterface.getModel(projectByPoid, roid, false);

					int calls = 0;
					int c = 0;
					List<IfcLocalPlacement> placements = model.getAllWithSubTypes(IfcLocalPlacement.class);
					Set<IfcCartesianPoint> changed = new HashSet<>();
					for (IfcLocalPlacement placement : placements) {
						IfcAxis2Placement relativePlacement = placement.getRelativePlacement();
						if (relativePlacement instanceof IfcAxis2Placement2D) {
							IfcAxis2Placement2D pl = (IfcAxis2Placement2D)relativePlacement;
							IfcCartesianPoint ifcCartesianPoint = pl.getLocation();
							if (ifcCartesianPoint != null && !changed.contains(ifcCartesianPoint)) {
								changed.add(ifcCartesianPoint);
								EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
								for (int i=0; i<coordinates.size(); i++) {
									coordinates.set(i, coordinates.get(i) * 2.0);
									calls++;
								}
							}
						} else if (relativePlacement instanceof IfcAxis2Placement3D) {
							IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
							IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
							if (ifcCartesianPoint != null && !changed.contains(ifcCartesianPoint)) {
								changed.add(ifcCartesianPoint);
								EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
								for (int i=0; i<coordinates.size(); i++) {
									coordinates.set(i, coordinates.get(i) * 2.0);
									calls++;
								}
							}
						}
						
						state = new SLongActionState();
						state.setTitle("Exploder");
						state.setState(SActionState.STARTED);
						state.setProgress((int)((double)c++ / placements.size() * 50.0));
						state.setStart(startDate);
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					}
					System.out.println("Nr Calls: " + calls);

					state = new SLongActionState();
					state.setTitle("Exploder");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					model.commit("Exploded model");
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Exploder");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
	}
}