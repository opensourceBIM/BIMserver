package org.bimserver.servlets;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.store.Revision;
import org.eclipse.emf.ecore.EClass;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class BinaryGeometryServlet extends SubServlet {

	public BinaryGeometryServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long start = System.nanoTime();
		ServletInputStream inputStream = request.getInputStream();
		byte[] bytes = IOUtils.toByteArray(inputStream);
		JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
		JsonParser parser = new JsonParser();
		JsonElement parse = parser.parse(jsonReader);
		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(response.getOutputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream);

		if (parse instanceof JsonObject) {
			JsonObject requestObject = (JsonObject) parse;
			DatabaseSession databaseSession = getBimServer().getDatabase().createSession();
			try {
				long roid = requestObject.get("roid").getAsLong();
				Revision revision = databaseSession.get(roid, Query.getDefault());
				int pid = revision.getProject().getId();
				int rid = revision.getRid();
				JsonArray typesJson = requestObject.get("types").getAsJsonArray();
				int nrObjects = 0;
				Bounds modelBounds = new Bounds();
				for (int i = 0; i < typesJson.size(); i++) {
					String type = typesJson.get(i).getAsString();
					EClass eClass = databaseSession.getEClassForName(type);
					if (eClass == null) {
						System.out.println("Unknown type: " + type);
					}
					Set<EClass> eClasses = new LinkedHashSet<EClass>();
					eClasses.add(eClass);
					if (true) {
						eClasses.addAll(getBimServer().getDatabase().getMetaDataManager().getAllSubClasses(eClass));
					}
					IfcModelInterface model = databaseSession.getAllOfTypes(eClasses, new Query(pid, rid, null, Deep.NO));
					for (IdEObject object : model.getAllWithSubTypes(eClass)) {
						if (object instanceof IfcProduct) {
							IfcProduct ifcProduct = (IfcProduct) object;
							GeometryInfo geometryInfo = ifcProduct.getGeometry();
							if (geometryInfo != null) {
								Bounds objectBounds = new Bounds(new Float3(geometryInfo.getMinBounds().getX(), geometryInfo.getMinBounds().getY(), geometryInfo.getMinBounds().getZ()),
										new Float3(geometryInfo.getMaxBounds().getX(), geometryInfo.getMaxBounds().getY(), geometryInfo.getMaxBounds().getZ()));
								modelBounds.integrate(objectBounds);
								nrObjects++;
							}
						}
					}
				}
				modelBounds.writeTo(dataOutputStream);
				dataOutputStream.writeInt(nrObjects);
				for (int i = 0; i < typesJson.size(); i++) {
					String type = typesJson.get(i).getAsString();
					EClass eClass = databaseSession.getEClassForName(type);
					if (eClass == null) {
						System.out.println("Unknown type: " + type);
					}
					Set<EClass> eClasses = new LinkedHashSet<EClass>();
					eClasses.add(eClass);
					if (true) {
						eClasses.addAll(getBimServer().getDatabase().getMetaDataManager().getAllSubClasses(eClass));
					}
					IfcModelInterface model = databaseSession.getAllOfTypes(eClasses, new Query(pid, rid, null, Deep.NO));

					for (IdEObject object : model.getAllWithSubTypes(eClass)) {
						if (object instanceof IfcProduct) {
							IfcProduct ifcProduct = (IfcProduct) object;
							GeometryInfo geometryInfo = ifcProduct.getGeometry();
							if (geometryInfo != null) {
								if (ifcProduct instanceof IfcSlab && ((IfcSlab)ifcProduct).getPredefinedType() == IfcSlabTypeEnum.ROOF) {
									dataOutputStream.writeUTF("IfcRoof");
								} else {
									dataOutputStream.writeUTF(ifcProduct.eClass().getName());
								}
								dataOutputStream.writeLong(ifcProduct.getOid());
								GeometryData geometryData = geometryInfo.getData();
								byte[] vertices = geometryData.getVertices();
								dataOutputStream.writeInt(vertices.length);
								
								ByteBuffer buffer = ByteBuffer.wrap(vertices);
								convertOrder(buffer);
								dataOutputStream.write(buffer.array());
								
								byte[] normals = geometryData.getNormals();
								dataOutputStream.writeInt(normals.length);
								
								buffer = ByteBuffer.wrap(normals);
								convertOrder(buffer);
								dataOutputStream.write(buffer.array());
							}
						}
					}
					dataOutputStream.flush();
				}
			} catch (BimserverDatabaseException e) {
				e.printStackTrace();
			} finally {
				databaseSession.close();
			}
		}
		gzipOutputStream.finish();
		gzipOutputStream.close();
		long end = System.nanoTime();
		System.out.println((((end - start) / 1000000) + " ms"));
	}
	
	private void convertOrder(ByteBuffer input) {
		input.position(0);
		for (int i=0; i<input.capacity(); i+=4) {
			input.order(ByteOrder.BIG_ENDIAN);
			float x = input.getFloat();
			input.order(ByteOrder.nativeOrder());
			input.position(input.position() - 4);
			input.putFloat(x);
		}
		input.position(0);
	}
}