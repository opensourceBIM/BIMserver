package org.bimserver.demoplugins.service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurniturePlacerServicePlugin extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(FurniturePlacerServicePlugin.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Furniture Placer";
	}

	@Override
	public String getDefaultName() {
		return "Furniture Placer";
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
		return "Furniture Placer";
	}

	@Override
	public void register(PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Furniture Placer");
		serviceDescriptor.setDescription("Furniture Placer");
		serviceDescriptor.setWriteRevision(true);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Furniture Placer");
					SLongActionState state = new SLongActionState();
					state.setTitle("Furniture Placer");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					IfcModelInterface model = bimServerClientInterface.getModel(poid, roid, true);
					
					DeserializerPlugin deserializerPlugin = getPluginManager().getFirstDeserializer("ifc", true);
					
					Deserializer deserializer = deserializerPlugin.createDeserializer(null);
					deserializer.init(getPluginManager().requireSchemaDefinition());

					deserializer = deserializerPlugin.createDeserializer(null);
					deserializer.init(getPluginManager().requireSchemaDefinition());
					InputStream resourceAsInputStream = getPluginManager().getPluginContext(FurniturePlacerServicePlugin.this).getResourceAsInputStream("data/picknicktable.ifc");
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					IOUtils.copy(resourceAsInputStream, byteArrayOutputStream);
					IfcModelInterface furnishingModel = deserializer.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), "picknicktable.ifc", byteArrayOutputStream.size());
					
					IfcFurnishingElement picknick = (IfcFurnishingElement) furnishingModel.getByName(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement(), "Picknik Bank");

					ModelHelper modelHelper = new ModelHelper(new HideAllInversesObjectIDM(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), getPluginManager().requireSchemaDefinition()), model);

					modelHelper.setTargetModel(model);
					modelHelper.setObjectFactory(model);
					
					IfcProductDefinitionShape representation = (IfcProductDefinitionShape) picknick.getRepresentation();
					IfcRepresentation surfaceModel = null;
					IfcRepresentation boundingBox = null;
					for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
						IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)ifcRepresentation;
						if (ifcShapeRepresentation.getRepresentationType().equals("SurfaceModel")) {
							surfaceModel = (IfcRepresentation) modelHelper.copy(ifcShapeRepresentation);
						} else if (ifcShapeRepresentation.getRepresentationType().equals("BoundingBox")) {
							boundingBox	 = (IfcRepresentation) modelHelper.copy(ifcShapeRepresentation);
						}
					}

					IfcOwnerHistory ownerHistory = null;
					List<IfcOwnerHistory> all = model.getAll(IfcOwnerHistory.class);
					if (all.size() > 0) {
						 ownerHistory = all.get(0);
					}
					
					for (IfcBuildingStorey ifcBuildingStorey : model.getAll(IfcBuildingStorey.class)) {
						for (IfcRelDecomposes ifcRelDecomposes : ifcBuildingStorey.getIsDecomposedBy()) {
							for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
								if (ifcObjectDefinition instanceof IfcSpace) {
									IfcSpace ifcSpace = (IfcSpace)ifcObjectDefinition;
//									IfcProductDefinitionShape slabRepr = (IfcProductDefinitionShape) ifcSpace.getRepresentation();
//									IfcBoundingBox box = null;
//									for (IfcRepresentation representation2 : slabRepr.getRepresentations()) {
//										IfcShapeRepresentation shapeRepresentation = (IfcShapeRepresentation)representation2;
//										if (shapeRepresentation.getRepresentationType().equals("BoundingBox")) {
//											for (IfcRepresentationItem i2 : shapeRepresentation.getItems()) {
//												box = (IfcBoundingBox)i2;
//											}
//										}
//									}
									
									IfcFurnishingElement newFurnishing = model.create(IfcFurnishingElement.class);
									
									IfcRelContainedInSpatialStructure containedInSpatialStructure2 = model.create(IfcRelContainedInSpatialStructure.class);
									containedInSpatialStructure2.setRelatingStructure(ifcBuildingStorey);
									containedInSpatialStructure2.getRelatedElements().add(newFurnishing);
									
									newFurnishing.setName("Generated");
									newFurnishing.setGlobalId("TEST");
									newFurnishing.setOwnerHistory(ownerHistory);
									IfcProductDefinitionShape definitionShape = model.create(IfcProductDefinitionShape.class);
									newFurnishing.setRepresentation(definitionShape);
									
									definitionShape.getRepresentations().add(boundingBox);
									definitionShape.getRepresentations().add(surfaceModel);
									
									IfcLocalPlacement localPlacement = model.create(IfcLocalPlacement.class);
									localPlacement.setPlacementRelTo(ifcSpace.getObjectPlacement());
									IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
									localPlacement.setRelativePlacement(axis2Placement3D);
									
									IfcCartesianPoint pos = model.create(IfcCartesianPoint.class);
									pos.getCoordinates().add(-3d);
									pos.getCoordinates().add(+0.5d);
									pos.getCoordinates().add(0d);
									axis2Placement3D.setLocation(pos);
									
									newFurnishing.setObjectPlacement(localPlacement);							
								}
							}
						}
					}

					model.commit("Added furniture");
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Furniture Placer");
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