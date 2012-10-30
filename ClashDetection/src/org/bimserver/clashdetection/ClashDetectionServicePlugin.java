package org.bimserver.clashdetection;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.bimserver.bcf.markup.Header;
import org.bimserver.bcf.markup.Header.File;
import org.bimserver.bcf.markup.Markup;
import org.bimserver.bcf.markup.Topic;
import org.bimserver.bcf.visinfo.Component;
import org.bimserver.bcf.visinfo.Direction;
import org.bimserver.bcf.visinfo.PerspectiveCamera;
import org.bimserver.bcf.visinfo.Point;
import org.bimserver.bcf.visinfo.VisualizationInfo;
import org.bimserver.clashdetection.bcf.Bcf;
import org.bimserver.clashdetection.bcf.BcfException;
import org.bimserver.clashdetection.bcf.Issue;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SNotifictionResultEnum;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineClash;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class ClashDetectionServicePlugin extends ServicePlugin {

	private boolean initialized;

	@Override
	public void init(final PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;

		ServiceDescriptor clashDetection = StoreFactory.eINSTANCE.createServiceDescriptor();
		clashDetection.setProviderName("BIMserver");
		clashDetection.setIdentifier(getClass().getName());
		clashDetection.setName("Clashdetection");
		clashDetection.setDescription("Clashdetection");
		clashDetection.setNotificationProtocol(AccessMethod.INTERNAL);
		clashDetection.setReadRevision(true);
		clashDetection.setWriteExtendedData("http://www.buildingsmart-tech.org/specifications/bcf-releases");
		clashDetection.setTrigger(Trigger.NEW_REVISION);
		
		registerNewRevisionHandler(clashDetection, new NewRevisionHandler(){
			public void newRevision(String uuid, ServiceInterface serviceInterface, SNewRevisionAdded notification, SObjectType settings) throws ServerException, UserException {
				Bcf bcf = new Bcf();
				
				SSerializerPluginConfiguration sSerializer = serviceInterface.getSerializerByContentType("application/ifc");
				
				long download = serviceInterface.download(notification.getRevisionId(), sSerializer.getOid(), true, true);
				SDownloadResult downloadData = serviceInterface.getDownloadData(download);
				
				try {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					((EmfSerializerDataSource)downloadData.getFile().getDataSource()).getSerializer().writeToOutputStream(baos);

					Deserializer deserializer = pluginManager.requireDeserializer("ifc").createDeserializer();
					deserializer.init(pluginManager.requireSchemaDefinition());
					IfcModelInterface model = deserializer.read(new ByteArrayInputStream(baos.toByteArray()), "test.ifc", true, baos.size());
					List<IfcProject> ifcProjects = model.getAll(IfcProject.class);
					IfcProject mainIfcProject = null;
					if (!ifcProjects.isEmpty()) {
						mainIfcProject = ifcProjects.get(0);
					}
					
					IfcEngine ifcEngine = pluginManager.requireIfcEngine().createIfcEngine();
					ifcEngine.init();
					
					IfcEngineModel ifcEngineModel = ifcEngine.openModel(new ByteArrayInputStream(baos.toByteArray()), baos.size());
					Set<IfcEngineClash> clashes = ifcEngineModel.findClashesWithEids(0.0);
					IfcEngineGeometry geometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
					for (IfcEngineClash clash : clashes) {
						IfcEngineInstanceVisualisationProperties vp = ifcEngineModel.getInstanceFromExpressId((int) clash.getEid1()).getVisualisationProperties();
						float x = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
						float y = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
						float z = geometry.getVertex(geometry.getIndex(vp.getStartIndex()));
						
						String guid1 = ((IfcRoot)model.get(clash.getEid1())).getGlobalId().getWrappedValue();
						String guid2 = ((IfcRoot)model.get(clash.getEid2())).getGlobalId().getWrappedValue();
						
						UUID topicUuid = UUID.randomUUID();
						Issue issue = new Issue(topicUuid);
						
						Markup markup = new Markup();
						Header header = new Header();
						File file = new File();
						file.setIfcProject(mainIfcProject.getGlobalId().getWrappedValue());
						file.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));				
						file.setFilename("C:\\Users\\Ruben de Laat\\Workspace\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc");
						
						header.getFile().add(file);
						
						markup.setHeader(header);

						Topic topic = new Topic();
						topic.setGuid(topicUuid.toString());
						topic.setTitle("Clash");
						
//						topic.setReferenceLink("project://projects/8d289643-c89a-4ffc-adec-2aedab679d6f");
						
						markup.setTopic(topic);
						
						VisualizationInfo visualizationInfo = new VisualizationInfo();
						
						Component component1 = new Component();
						component1.setIfcGuid(guid1);
						component1.setOriginatingSystem("BIMserver");
//						component1.setAuthoringToolId("" + clash.getEid1());

						Component component2 = new Component();
						component2.setIfcGuid(guid2);
						component2.setOriginatingSystem("BIMserver");
//						component2.setAuthoringToolId("" + clash.getEid2());
						
						VisualizationInfo.Components components = new VisualizationInfo.Components();
						visualizationInfo.setComponents(components);
						components.getComponent().add(component1);
						components.getComponent().add(component2);
						
						PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
						perspectiveCamera.setFieldOfView(45.0);
						perspectiveCamera.setCameraUpVector(newDirection(0, 0, 1));
						perspectiveCamera.setCameraViewPoint(newPoint(x - 100, y, z));
						perspectiveCamera.setCameraDirection(newDirection(x, y, z));
						
						visualizationInfo.setPerspectiveCamera(perspectiveCamera);
						visualizationInfo.setLines(new VisualizationInfo.Lines());
						visualizationInfo.setClippingPlanes(new VisualizationInfo.ClippingPlanes());
						
						BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
						ByteArrayOutputStream baosImage = new ByteArrayOutputStream();
						ImageIO.write(bufferedImage, "png", baosImage);
						
						issue.setMarkup(markup);
						issue.setVisualizationInfo(visualizationInfo);
						issue.setImageData(baosImage.toByteArray());
						
						bcf.addIssue(issue);
					}
				} catch (IfcEngineException e) {
					e.printStackTrace();
				} catch (PluginException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				} catch (DeserializeException e) {
					e.printStackTrace();
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				
				SExtendedDataSchema extendedDataSchemaByNamespace = serviceInterface.getExtendedDataSchemaByNamespace("http://www.buildingsmart-tech.org/specifications/bcf-releases");

				SFile file = new SFile();
				
				SExtendedData extendedData = new SExtendedData();
				extendedData.setTitle("Clashdetection Results");
				file.setFilename("clashdetection.bcfzip");
				extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
				try {
					byte[] bytes = bcf.toBytes();
					file.setData(bytes);
					file.setMime("application/bcf");
					
					long fileId = serviceInterface.uploadFile(file);
					extendedData.setFileId(fileId);
					
					serviceInterface.addExtendedDataToRevision(notification.getRevisionId(), extendedData);
				} catch (BcfException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public SImmediateNotificationResult getImmediateNotificationResult() {
				SImmediateNotificationResult sImmediateNotificationResult = new SImmediateNotificationResult();
				sImmediateNotificationResult.setResult(SNotifictionResultEnum.PROGRESS_UNKNOWN);
				sImmediateNotificationResult.setDescription("Running ClashDetection");
				return sImmediateNotificationResult;
			}
		});
	}

	private Point newPoint(double x, double y, double z) {
		Point point = new Point();
		point.setX(x);
		point.setY(y);
		point.setZ(z);
		return point;
	}

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
}