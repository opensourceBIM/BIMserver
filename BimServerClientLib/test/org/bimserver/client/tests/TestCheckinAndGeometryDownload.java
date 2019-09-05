package org.bimserver.client.tests;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.notifications.BinaryMessageListener;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.database.queries.om.Tiles;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestCheckinAndGeometryDownload {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestCheckinAndGeometryDownload.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			for (int i=0; i<100; i++) {
				try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
					SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
					
					SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
					Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\export1.ifc");
					SLongCheckinActionState checkinSync = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
						@Override
						public void progress(String title, int progress) {
//							System.out.println(title + ": " + progress);
						}
					});
					
					PackageMetaData packageMetaData = client.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
					Query query = new Query(packageMetaData);
					
					QueryPart queryPart = query.createQueryPart();
					queryPart.addType(packageMetaData.getEClass("IfcProduct"), true);
					Tiles tiles = new Tiles();
					tiles.add(0);
					tiles.setMaximumThreshold(1000);
					tiles.setMaxDepth(0);
					queryPart.setTiles(tiles);
					Include include1 = queryPart.createInclude();
					include1.addType(packageMetaData.getEClass("IfcProduct"), true);
					include1.addField("geometry");
					Include include2 = include1.createInclude();
					include2.addType(GeometryPackage.eINSTANCE.getGeometryInfo(), false);
					include2.addField("data");
					Include include3 = include2.createInclude();
					include3.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);
					include3.addFieldDirect("indices");
					include3.addFieldDirect("normals");
					include3.addFieldDirect("normalsQuantized");
					include3.addFieldDirect("vertices");
					include3.addFieldDirect("verticesQuantized");
					include3.addFieldDirect("colorsQuantized");
					include3.addFieldDirect("colorPack");
					
					SSerializerPluginConfiguration serializer = client.getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometryMessagingStreamingSerializerPlugin");
					
					ObjectNode queryJson = new JsonQueryObjectModelConverter(packageMetaData).toJson(query);
					queryJson.set("loaderSettings", generateLoaderSettings());
					String queryString = queryJson.toString();
					Long topicId = client.getServiceInterface().download(Collections.singleton(checkinSync.getRoid()), queryString, serializer.getOid(), false);
					
					ObjectNode downloadMessage = OBJECT_MAPPER.createObjectNode();
					downloadMessage.put("action", "download");
					downloadMessage.put("token", client.getToken());
					downloadMessage.put("topicId", topicId);
					
					CountDownLatch doneCountdown = new CountDownLatch(1);
					client.getNotificationsManager().setBinaryMessageListener(topicId, new BinaryMessageListener() {
						@Override
						public void newData(byte[] bytes, int start, int length) {
							ByteBuffer buffer = ByteBuffer.wrap(bytes, start, length).order(ByteOrder.LITTLE_ENDIAN);
							buffer.getLong(); // TopicId
							int type = buffer.getInt();
							
							if (type == 0) {
							} else if (type == 1) {
								doneCountdown.countDown();
							}
						}
					});
					client.getNotificationsManager().send(downloadMessage);
					
					if (!doneCountdown.await(5, TimeUnit.MINUTES)) {
						LOGGER.error("Not finished after 5 minutes!");
					}
					LOGGER.info("Done");
					
					client.getServiceInterface().cleanupLongAction(topicId);
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private JsonNode generateLoaderSettings() {
		ObjectNode loaderSettings = OBJECT_MAPPER.createObjectNode();
//		loaderSettings.set("vertexQuantizationMatrix", metaDataNode.get("vertexQuantizationMatrix"));
//		loaderSettings.set("globalTranslationVector", metaDataNode.get("globalTranslationVector"));
		loaderSettings.put("useObjectColors", false);
		loaderSettings.put("quantizeNormals", true);
		loaderSettings.put("quantizeVertices", false);
		loaderSettings.put("quantizeColors", true);
		loaderSettings.put("splitGeometry", false);
		loaderSettings.put("normalizeUnitsToMM", true);
		loaderSettings.put("useSmallInts", false);
		loaderSettings.put("tilingLayerReuse", false);
		loaderSettings.put("reuseThreshold", 25000);
		loaderSettings.put("prepareBuffers", true);
		loaderSettings.put("reportProgress", false);

		return loaderSettings;
	}
}
