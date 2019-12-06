package org.bimserver.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Buffer;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GeometryLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryLoader.class);
	private PackageMetaData packageMetaData;
	private int bytesRead;
	private GeometryTarget geometryTarget;
	private BimServerClient bimServerClient;

	public GeometryLoader(BimServerClient bimServerClient, PackageMetaData packageMetaData, GeometryTarget geometryTarget) {
		this.bimServerClient = bimServerClient;
		this.packageMetaData = packageMetaData;
		this.geometryTarget = geometryTarget;
	}
	
	public void load(InputStream inputStream) throws GeometryException, IOException, ObjectAlreadyExistsException, IfcModelInterfaceException {
		int t = 0;
		CountingLittleEndianDataInputStream dataInputStream = new CountingLittleEndianDataInputStream(inputStream);
		try {
			boolean done = false;
			while (true) {
				byte geometryType = dataInputStream.readByte();
				if (geometryType == 0) {
					String protocol = dataInputStream.readUTF();
					if (!protocol.equals("BGS")) {
						throw new GeometryException("Protocol != BGS (" + protocol + ")");
					}
					byte formatVersion = dataInputStream.readByte();
					if (formatVersion != 20) {
						throw new GeometryException("Unsupported version " + formatVersion + " / 20");
					}

					float multiplierToMm = dataInputStream.readFloat();
					dataInputStream.align8();
					for (int i = 0; i < 6; i++) {
						dataInputStream.readDouble();
					}
				} else if (geometryType == 5) {
					boolean isInPreparedBuffer = dataInputStream.readByte() == 1;
					long ifcProductOid = dataInputStream.readLong();
					String type = dataInputStream.readUTF();
					int nrColors = dataInputStream.readInt();
					dataInputStream.align8();
					long roid = dataInputStream.readLong(); // roid
					long geometryInfoOid = dataInputStream.readLong();
					boolean hasTransparency = dataInputStream.readLong() == 1; // transparent
					GeometryInfo geometryInfo = (GeometryInfo) geometryTarget.get(geometryInfoOid);
					if (geometryInfo == null) {
						geometryInfo = geometryTarget.create(GeometryInfo.class);
					}
					((IdEObjectImpl) geometryInfo).setOid(geometryInfoOid);
					((IdEObjectImpl) geometryInfo).setLoadingState(State.LOADING);
					geometryTarget.add(geometryInfoOid, geometryInfo);

					IdEObject ifcProduct = geometryTarget.get(ifcProductOid);

					EStructuralFeature geometryFeature = packageMetaData.getEClass("IfcProduct").getEStructuralFeature("geometry");
					if (ifcProduct != null) {
						ifcProduct.eSet(geometryFeature, geometryInfo);
					}

					org.bimserver.models.geometry.Vector3f minBounds = GeometryFactory.eINSTANCE.createVector3f();
					minBounds.setX(dataInputStream.readDouble());
					minBounds.setY(dataInputStream.readDouble());
					minBounds.setZ(dataInputStream.readDouble());

					org.bimserver.models.geometry.Vector3f maxBounds = GeometryFactory.eINSTANCE.createVector3f();
					maxBounds.setX(dataInputStream.readDouble());
					maxBounds.setY(dataInputStream.readDouble());
					maxBounds.setZ(dataInputStream.readDouble());

					Bounds bounds = GeometryFactory.eINSTANCE.createBounds();

					bounds.setMin(minBounds);
					bounds.setMax(maxBounds);

					geometryInfo.setBounds(bounds);

					byte[] transformation = new byte[16 * 8];
					dataInputStream.readFully(transformation);
					geometryInfo.setTransformation(transformation);

					long geometryDataOid = dataInputStream.readLong();
					GeometryData geometryData = (GeometryData) geometryTarget.get(geometryDataOid);
					if (geometryData == null) {
						geometryData = GeometryFactory.eINSTANCE.createGeometryData();
						geometryTarget.add(geometryDataOid, geometryData);
					} else {
						geometryInfo.setNrVertices(geometryData.getNrVertices());
						geometryInfo.setNrColors(geometryData.getNrColors());
						geometryInfo.setPrimitiveCount(geometryData.getNrIndices() / 3);
					}
					geometryInfo.setData(geometryData);
					((IdEObjectImpl) geometryData).setLoadingState(State.LOADED);
				} else if (geometryType == 3) {
					throw new GeometryException("Parts not supported");
				} else if (geometryType == 1) {
					int reused = dataInputStream.readInt();
					String type = dataInputStream.readUTF();
					dataInputStream.align8();
					long roid = dataInputStream.readLong();
					long croid = dataInputStream.readLong();
					boolean hasTransparency = dataInputStream.readLong() == 1; // transparent
					long geometryDataOid = dataInputStream.readLong();

					GeometryData geometryData = (GeometryData) geometryTarget.get(geometryDataOid);
					if (geometryData == null) {
						geometryData = GeometryFactory.eINSTANCE.createGeometryData();
						geometryTarget.add(geometryDataOid, geometryData);
					}
					((IdEObjectImpl) geometryData).setOid(geometryDataOid);
					((IdEObjectImpl) geometryData).setLoadingState(State.LOADING);

					int nrIndices = dataInputStream.readInt();
					byte[] indices = new byte[nrIndices * 4];
					dataInputStream.readFully(indices);
					Buffer buffer = GeometryFactory.eINSTANCE.createBuffer();
					buffer.setData(indices);
					geometryData.setIndices(buffer);

					geometryData.setNrIndices(indices.length / 4);
					
					int colorType = dataInputStream.readInt();
					if (colorType == 1) {
						dataInputStream.readFloat();
						dataInputStream.readFloat();
						dataInputStream.readFloat();
						dataInputStream.readFloat();
					}

					int nrVertices = dataInputStream.readInt();
					byte[] vertices = new byte[nrVertices * 4];
					dataInputStream.readFully(vertices);
					Buffer verticesBuffer = GeometryFactory.eINSTANCE.createBuffer();
					verticesBuffer.setData(vertices);
					geometryData.setVertices(verticesBuffer);
					
					geometryData.setNrVertices(vertices.length / 4);

					int nrNormals = dataInputStream.readInt();
					byte[] normals = new byte[nrNormals * 4];
					dataInputStream.readFully(normals);
					Buffer normalsBuffer = GeometryFactory.eINSTANCE.createBuffer();
					normalsBuffer.setData(normals);
					geometryData.setNormals(normalsBuffer);

					geometryData.setNrNormals(normals.length / 4);
					
					int nrMaterials = dataInputStream.readInt();
					byte[] materials = new byte[nrMaterials];
					dataInputStream.readFully(materials);
					Buffer colorsBuffer = GeometryFactory.eINSTANCE.createBuffer();
					colorsBuffer.setData(materials);
					geometryData.setColorsQuantized(colorsBuffer);
					geometryData.setNrColors(materials.length);

					((IdEObjectImpl) geometryData).setLoadingState(State.LOADED);
				} else if (geometryType == 6) {
					done = true;
				} else {
					throw new GeometryException("Unimplemented geometryType: " + geometryType);
				}
				t++;
				dataInputStream.align8();
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.out.println("T: " + t);
			e.printStackTrace();
		} finally {
			dataInputStream.close();
			this.bytesRead += dataInputStream.getPos();
//			this.clientDebugInfo.incBytesOverTheLine(dataInputStream.getPos());
		}
	}

	public void loadProducts(long roid, Set<Long> oids) throws QueryException, ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		Query query = new Query("test", packageMetaData);
		ObjectNode settings = new ObjectMapper().createObjectNode();
		query.setGeometrySettings(settings);
		query.getGeometrySettings().put("useSmallInts", false);
		query.getGeometrySettings().put("splitGeometry", false);
		query.getGeometrySettings().put("quantizeColors", true);
		QueryPart queryPart = query.createQueryPart();

		queryPart.addOids(oids);

		if (queryPart.getOids() == null) {
			return;
		}
		LOGGER.info("Loading geometry for " + queryPart.getOids().size() + " objects");
		Include productInclude = queryPart.createInclude();
		productInclude.addType(packageMetaData.getEClass("IfcProduct"), true);
		productInclude.addField("geometry");
		EClass geometryInfoClass = packageMetaData.getEClassIncludingDependencies("GeometryInfo");
		Include include = productInclude.createInclude();
		include.addType(geometryInfoClass, false);
		include.addField("data");
		Include geometryData = include.createInclude();
		geometryData.addType(packageMetaData.getEClassIncludingDependencies("GeometryData"), false);
		geometryData.addFieldDirect("indices");
		geometryData.addFieldDirect("normals");
		geometryData.addFieldDirect("vertices");
		geometryData.addFieldDirect("colorsQuantized");

		long serializerOid = bimServerClient.getBinaryGeometryMessagingStreamingSerializerOid();

		fetch(roid, query, serializerOid);		
	}
	
	public void loadGeometryData(long roid, Set<Long> oids) throws QueryException, ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		Query query = new Query("test", packageMetaData);
		ObjectNode settings = new ObjectMapper().createObjectNode();
		query.setGeometrySettings(settings);
		query.getGeometrySettings().put("useSmallInts", false);
		query.getGeometrySettings().put("splitGeometry", false);
		query.getGeometrySettings().put("quantizeColors", true);
		QueryPart queryPart = query.createQueryPart();

		queryPart.addOids(oids);

		if (queryPart.getOids() == null) {
			return;
		}
		LOGGER.info("Loading geometry for " + queryPart.getOids().size() + " objects");
		Include geometryData = queryPart.createInclude();
		geometryData.addType(packageMetaData.getEClassIncludingDependencies("GeometryData"), false);
		geometryData.addFieldDirect("indices");
		geometryData.addFieldDirect("normals");
		geometryData.addFieldDirect("vertices");
		geometryData.addFieldDirect("colorsQuantized");

		long serializerOid = bimServerClient.getBinaryGeometryMessagingStreamingSerializerOid();

		fetch(roid, query, serializerOid);		
	}

	private void fetch(long roid, Query query, long serializerOid) throws ServerException, UserException, IOException {
		long topicId = bimServerClient.query(query, roid, serializerOid);
		// TODO use websocket notifications
		bimServerClient.waitForDonePreparing(topicId);
		try (InputStream inputStream = bimServerClient.getDownloadData(topicId)) {
			load(inputStream);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			bimServerClient.getServiceInterface().cleanupLongAction(topicId);
		}
	}
	
	public GeometryTarget getGeometryTarget() {
		return geometryTarget;
	}
}
