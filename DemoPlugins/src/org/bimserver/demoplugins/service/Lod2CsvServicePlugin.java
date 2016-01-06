package org.bimserver.demoplugins.service;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProxy;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.eclipse.emf.ecore.EAttribute;

import com.google.common.base.Charsets;

import au.com.bytecode.opencsv.CSVWriter;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Lod2CsvServicePlugin extends AbstractAddExtendedDataService {
	private static final String NAMESPACE = "http://bimserver.org/lodcsv";
	
	public Lod2CsvServicePlugin() {
		super("LOD to CSV", "LOD to CSV", NAMESPACE);
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid,
			long roid, String userToken, long soid, SObjectType settings) throws Exception {
		SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
		IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);
		
		ByteArrayOutputStream outAll = new ByteArrayOutputStream();
		ByteArrayOutputStream outNoFurniture = new ByteArrayOutputStream();
		ByteArrayOutputStream outNoProxy = new ByteArrayOutputStream();

		CSVWriter csvWriterAll = new CSVWriter(new OutputStreamWriter(outAll, Charsets.UTF_8));
		CSVWriter csvWriterNoFurniture = new CSVWriter(new OutputStreamWriter(outNoFurniture, Charsets.UTF_8));
		CSVWriter csvWriterNoProxy = new CSVWriter(new OutputStreamWriter(outNoProxy, Charsets.UTF_8));

	    createHeader(csvWriterAll);
	    createHeader(csvWriterNoFurniture);
	    createHeader(csvWriterNoProxy);

		float scaleFactorToMeter = 1;

		for (IfcSIUnit ifcSIUnit : model.getAll(IfcSIUnit.class)) {
			if (ifcSIUnit.getUnitType() == IfcUnitEnum.LENGTHUNIT) {
				IfcSIUnitName ifcSiUnitName = ifcSIUnit.getName();
				if (IfcSIUnitName.METRE == ifcSiUnitName) {
					IfcSIPrefix lengthPrefix = ifcSIUnit.getPrefix();
					System.out.println("Using length unit " + lengthPrefix);
					if (lengthPrefix == IfcSIPrefix.DECA) {
						scaleFactorToMeter = 10f;
					} else if (lengthPrefix == IfcSIPrefix.CENTI) {
						scaleFactorToMeter = 0.1f;
					} else if (lengthPrefix == IfcSIPrefix.DECI) {
						scaleFactorToMeter = 0.01f;
					} else if (lengthPrefix == IfcSIPrefix.MILLI) {
						scaleFactorToMeter = 0.001f;
					} else if (lengthPrefix == IfcSIPrefix.NULL) {
						scaleFactorToMeter = 1;
					} else {
						System.out.println("Unimplemented prefix " + lengthPrefix);
					}
				} else {
					System.out.println("Lengthunit not meters?!?");
				}
			}
		}
		
		double cubicScaleFactor = Math.pow(scaleFactorToMeter, 3);
		
		int totalNrTriangles = 0;
		int totalNrTrianglesNoProxies = 0;
		int totalNrTrianglesNoFurniture = 0;
		int nrIfcProducts = 0;
		int nrIfcProductsNoFurniture = 0;
		int nrIfcProductsNoProxies = 0;
		
		Bounds totalBounds = new Bounds();
		
		int totalUsedAttributes = 0;
		int totalUsedAttributesNoFurniture = 0;
		int totalUsedAttributesNoProxies = 0;
		
		double totalSpaceM3 = 0;
		
//			ObjectMapper objectMapper = new ObjectMapper();
//			ObjectNode query = objectMapper.createObjectNode();
//			ArrayNode queries = objectMapper.createArrayNode();
//			query.set("queries", queries);
//			ObjectNode geometryQuery = objectMapper.createObjectNode();
//			queries.add(geometryQuery);
//			geometryQuery.put("type", "GeometryInfo");
		
//			System.out.println("Query");
//			model.query(query);
		
//			System.out.println(model.getAll(GeometryInfo.class));
//			System.out.println(model.getAll(Vector3f.class));
		
		int nrSpaces = 0;
		
		for (IfcSpace ifcSpace : model.getAll(IfcSpace.class)) {
			if (ifcSpace.getGeometry() != null) {
				Vector3f minBounds = ifcSpace.getGeometry().getMinBounds();
				Vector3f maxBounds = ifcSpace.getGeometry().getMinBounds();
				
				double v = cubicScaleFactor * (maxBounds.getX() - minBounds.getX() * (maxBounds.getY() - minBounds.getY()) * (maxBounds.getZ() - minBounds.getZ()));
				totalSpaceM3 += v;
				nrSpaces++;
			}
		}
		
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			GeometryInfo geometry = ifcProduct.getGeometry();
			if (geometry != null) {
				totalBounds.integrate(new Bounds(geometry.getMinBounds(), geometry.getMaxBounds()));
				
				totalNrTriangles += geometry.getPrimitiveCount();
				if (!(ifcProduct instanceof IfcFurnishingElement)) {
					totalNrTrianglesNoFurniture += geometry.getPrimitiveCount();
				}
				if (!(ifcProduct instanceof IfcProxy)) {
					totalNrTrianglesNoProxies += geometry.getPrimitiveCount();
				}
				int usedAttributes = 0;
				for (EAttribute eAttribute : ifcProduct.eClass().getEAllAttributes()) {
					Object val = ifcProduct.eGet(eAttribute);
					if (eAttribute.isMany()) {
						List<?> list = (List<?>)val;
						if (list.size() > 0) {
							usedAttributes++;
						}
					} else {
						if (val != null) {
							usedAttributes++;
						}
					}
				}
				
				for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
						IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						if (propertySetDefinition instanceof IfcPropertySet) {
							IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
							usedAttributes += ifcPropertySet.getHasProperties().size();
						}
					}
				}
				totalUsedAttributes += usedAttributes;
				nrIfcProducts++;
				if (!(ifcProduct instanceof IfcFurnishingElement)) {
					totalUsedAttributesNoFurniture += usedAttributes;
					nrIfcProductsNoFurniture++;
				}
				if (!(ifcProduct instanceof IfcProxy)) {
					totalUsedAttributesNoProxies += usedAttributes;
					nrIfcProductsNoProxies++;
				}
			}
		}
		
		writeRow(csvWriterAll, cubicScaleFactor, totalNrTriangles, nrIfcProducts, totalBounds, totalUsedAttributes, totalSpaceM3, nrSpaces);
		writeRow(csvWriterNoFurniture, cubicScaleFactor, totalNrTrianglesNoFurniture, nrIfcProductsNoFurniture, totalBounds, totalUsedAttributesNoFurniture, totalSpaceM3, nrSpaces);
		writeRow(csvWriterNoProxy, cubicScaleFactor, totalNrTrianglesNoProxies, nrIfcProductsNoProxies, totalBounds, totalUsedAttributesNoProxies, totalSpaceM3, nrSpaces);
		
	    csvWriterAll.close();
	    csvWriterNoFurniture.close();
	    csvWriterNoProxy.close();
		
		addExtendedData(outAll.toByteArray(), "all.csv", "All objects", "text/csv", bimServerClientInterface, roid);
		addExtendedData(outNoFurniture.toByteArray(), "nofurniture.csv", "All objects except furniture", "text/csv", bimServerClientInterface, roid);
		addExtendedData(outNoProxy.toByteArray(), "noproxy.csv", "All objects except proxies", "text/csv", bimServerClientInterface, roid);
	}

	private void writeRow(CSVWriter csvWriter, double cubicScaleFactor, int totalNrTriangles, int nrIfcProducts, Bounds totalBounds, int totalUsedProperties, double totalSpaceM3, int nrSpaces) throws WriteException, RowsExceededException {
		double volume = cubicScaleFactor * (totalBounds.maxX - totalBounds.minX) * (totalBounds.maxY - totalBounds.minY) * (totalBounds.maxZ - totalBounds.minZ);
		csvWriter.writeNext(new String[]{
			String.valueOf(nrIfcProducts),
			String.format("%.2f", volume),
			"" + nrSpaces,
			String.format("%.2f", totalSpaceM3),
			String.valueOf(totalNrTriangles),
			String.format("%.2f", nrIfcProducts / volume),
			String.format("%.2f", totalNrTriangles / volume),
			String.format("%.2f", totalSpaceM3 != 0f ? (nrIfcProducts / totalSpaceM3) : Float.NaN),
			String.format("%.2f", totalSpaceM3 != 0f ? (totalNrTriangles / totalSpaceM3) : Float.NaN),
			String.format("%.2f", (totalUsedProperties) / (float)nrIfcProducts)
		});
	}

	private void createHeader(CSVWriter csvWriter) throws WriteException, RowsExceededException {
		csvWriter.writeNext(new String[]{
			"# Objects",
			"Volume M\u00B3",
			"# Spaces",
			"Space Volume M\u00B3",
			"# Triangles",
			"# Objects / Volume M\u00B3",
			"# Triangles / Volume M\u00B3",
			"# Objects / Space Volume m\u00B3",
			"# Triangles / Space Volume M\u00B3",
			"Avg. # Object properties / Object"
		});
	}
	
	class Bounds {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double minZ = Double.MAX_VALUE;
		double maxX = -Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;
		double maxZ = -Double.MAX_VALUE;

		public Bounds(Vector3f minBounds, Vector3f maxBounds) {
			minX = minBounds.getX();
			minY = minBounds.getY();
			minZ = minBounds.getZ();
			maxX = maxBounds.getX();
			maxY = maxBounds.getY();
			maxZ = maxBounds.getZ();
		}

		public Bounds() {
		}

		public void integrate(Bounds bounds) {
			if (bounds.maxX > maxX) {
				maxX = bounds.maxX;
			}
			if (bounds.maxY > maxY) {
				maxY = bounds.maxY;
			}
			if (bounds.maxZ > maxZ) {
				maxZ = bounds.maxZ;
			}
			if (bounds.minX < minX) {
				minX = bounds.minX;
			}
			if (bounds.minY < minY) {
				minY = bounds.minY;
			}
			if (bounds.minZ < minZ) {
				minZ = bounds.minZ;
			}
		}
		
		@Override
		public String toString() {
			return minX + ", " + minY + ", " + minZ + ", " + maxX + ", " + maxY + ", " + maxZ;
		}
	}
}