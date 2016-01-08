package org.bimserver.clashdetection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.activation.DataSource;

import org.bimserver.bcf.visinfo.Direction;
import org.bimserver.bcf.visinfo.Point;
import org.bimserver.clashdetection.bcf.Bcf;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.plugins.stillimagerenderer.StillImageRenderer;
import org.bimserver.plugins.stillimagerenderer.StillImageRendererException;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.ByteArrayDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClashDetectionServicePlugin extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClashDetectionServicePlugin.class);
	private boolean initialized;

	@Override
	public void init(final PluginManagerInterface pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	public void register(long uoid, SInternalServicePluginConfiguration internalServicePluginConfiguration, final PluginConfiguration pluginConfiguration) {
		ServiceDescriptor clashDetection = StoreFactory.eINSTANCE.createServiceDescriptor();
		clashDetection.setProviderName("BIMserver");
		clashDetection.setIdentifier("" + internalServicePluginConfiguration.getOid());
		clashDetection.setName("Clashdetection");
		clashDetection.setDescription("Clashdetection");
		clashDetection.setNotificationProtocol(AccessMethod.INTERNAL);
		clashDetection.setReadRevision(true);
		clashDetection.setWriteExtendedData("http://www.buildingsmart-tech.org/specifications/bcf-releases");
		clashDetection.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(uoid, clashDetection, new NewRevisionHandler() {
			@SuppressWarnings("unused")
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				Bcf bcf = new Bcf();

				SSerializerPluginConfiguration sSerializer;
				try {
					sSerializer = bimServerClientInterface.getPluginInterface().getSerializerByPluginClassName("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin");

					long download = bimServerClientInterface.getBimsie1ServiceInterface().download(roid, sSerializer.getOid(), true, true);
					SDownloadResult downloadData = bimServerClientInterface.getBimsie1ServiceInterface().getDownloadData(download);

					try {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						DataSource dataSource = downloadData.getFile().getDataSource();
						if (dataSource instanceof ByteArrayDataSource) {
							org.apache.commons.io.IOUtils.copy(((ByteArrayDataSource) dataSource).getInputStream(), baos);
						} else {
							((EmfSerializerDataSource) dataSource).getSerializer().writeToOutputStream(baos, null);
						}

						Deserializer deserializer = getPluginManager().requireDeserializer("ifc").createDeserializer(new PluginConfiguration());
//						deserializer.init(getPluginManager().requireSchemaDefinition());
						IfcModelInterface model = deserializer.read(new ByteArrayInputStream(baos.toByteArray()), "test.ifc", baos.size());
						List<IfcProject> ifcProjects = model.getAll(IfcProject.class);
						IfcProject mainIfcProject = null;
						if (!ifcProjects.isEmpty()) {
							mainIfcProject = ifcProjects.get(0);
						}

						RenderEngine renderEngine = getPluginManager().requireRenderEngine().createRenderEngine(new PluginConfiguration(), "ifc2x3tc1");
						renderEngine.init();

						RenderEngineModel renderEngineModel = renderEngine.openModel(new ByteArrayInputStream(baos.toByteArray()), baos.size());

						StillImageRenderer stillImageRenderer = getPluginManager().getFirstStillImageRenderPlugin().create(new PluginConfiguration());
						boolean renderImage = true;
						try {
							stillImageRenderer.init(model);
						} catch (StillImageRendererException e) {
							renderImage = false;
						}

//						ClashDetector clashDetector = new ClashDetector(model.getAll(GeometryInfo.class));
//						List<Clash> clashes = clashDetector.findClashes();
						
//						for (RenderEngineClash clash : clashes) {
//							RenderEngineInstanceVisualisationProperties vp = renderEngineModel.getInstanceFromExpressId((int) clash.getEid1()).getVisualisationProperties();
//							float x = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
//							float y = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
//							float z = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
//
//							String guid1 = ((IfcRoot) model.get(clash.getEid1())).getGlobalId();
//							String guid2 = ((IfcRoot) model.get(clash.getEid2())).getGlobalId();
//
//							UUID topicUuid = UUID.randomUUID();
//							Issue issue = new Issue(topicUuid);
//
//							Markup markup = new Markup();
//							Header header = new Header();
//							File file = new File();
//							file.setIfcProject(mainIfcProject.getGlobalId());
//							file.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
//							file.setFilename("C:\\Users\\Ruben de Laat\\Workspace\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc");
//
//							header.getFile().add(file);
//
//							markup.setHeader(header);
//
//							Topic topic = new Topic();
//							topic.setGuid(topicUuid.toString());
//							topic.setTitle("Clash");
//
//							// topic.setReferenceLink("project://projects/8d289643-c89a-4ffc-adec-2aedab679d6f");
//
//							markup.setTopic(topic);
//
//							VisualizationInfo visualizationInfo = new VisualizationInfo();
//
//							Component component1 = new Component();
//							component1.setIfcGuid(guid1);
//							component1.setOriginatingSystem("BIMserver");
//							component1.setAuthoringToolId("" + clash.getEid1());
//
//							Component component2 = new Component();
//							component2.setIfcGuid(guid2);
//							component2.setOriginatingSystem("BIMserver");
//							component2.setAuthoringToolId("" + clash.getEid2());
//
//							VisualizationInfo.Components components = new VisualizationInfo.Components();
//							visualizationInfo.setComponents(components);
//							components.getComponent().add(component1);
//							components.getComponent().add(component2);
//
//							PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
//							perspectiveCamera.setFieldOfView(45.0);
//							perspectiveCamera.setCameraUpVector(newDirection(0, 0, 1));
//							perspectiveCamera.setCameraViewPoint(newPoint(x - 100, y, z));
//							perspectiveCamera.setCameraDirection(newDirection(x, y, z));
//
//							visualizationInfo.setPerspectiveCamera(perspectiveCamera);
//							visualizationInfo.setLines(new VisualizationInfo.Lines());
//							visualizationInfo.setClippingPlanes(new VisualizationInfo.ClippingPlanes());
//
//							if (renderImage) {
//								byte[] snapshot = stillImageRenderer.snapshot(new Vector3f(x - 100, y, z), new Vector3f(0, 0, 1), new Vector3f(x, y, z), 500, 500, null);
//								issue.setImageData(snapshot);
//							} else {
//								ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
//								ImageIO.write(new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB), "PNG", baos2);
//								issue.setImageData(baos2.toByteArray());
//							}
//
//							issue.setMarkup(markup);
//							issue.setVisualizationInfo(visualizationInfo);
//
//							bcf.addIssue(issue);
//						}
					} catch (Exception e) {
						LOGGER.error("", e);
					}

					SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(
							"http://www.buildingsmart-tech.org/specifications/bcf-releases");

					SFile file = new SFile();

					SExtendedData extendedData = new SExtendedData();
					extendedData.setTitle("Clashdetection Results");
					file.setFilename("clashdetection.bcfzip");
					extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
					try {
						byte[] bytes = bcf.toBytes();
						file.setData(bytes);
						file.setMime("application/bcf");

						long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
						extendedData.setFileId(fileId);

						bimServerClientInterface.getBimsie1ServiceInterface().addExtendedDataToRevision(roid, extendedData);
					} catch (Exception e) {
						LOGGER.error("", e);
					}
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private Point newPoint(double x, double y, double z) {
		Point point = new Point();
		point.setX(x);
		point.setY(y);
		point.setZ(z);
		return point;
	}

	@SuppressWarnings("unused")
	private Direction newDirection(double x, double y, double z) {
		Direction direction = new Direction();
		direction.setX(x);
		direction.setY(y);
		direction.setZ(z);
		return direction;
	}

	@Override
	public String getDescription() {
		return "Provides clash detection service";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Clashdetection";
	}

	@Override
	public String getDefaultName() {
		return "ClashDetection";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		ParameterDefinition marginParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		marginParameter.setName("margin");
		marginParameter.setRequired(true);
		DoubleType defaultValue = StoreFactory.eINSTANCE.createDoubleType();
		defaultValue.setValue(0.0);
		marginParameter.setDefaultValue(defaultValue);
		PrimitiveDefinition doubleDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		doubleDefinition.setType(PrimitiveEnum.DOUBLE);
		marginParameter.setType(doubleDefinition);
		objectDefinition.getParameters().add(marginParameter);
		return objectDefinition;
	}

	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
	}
}