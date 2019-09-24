package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.renderengine.VersionInfo;
import org.bimserver.utils.Formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GeometryGenerationReport {

	private static final String REPORT_VERSION = "1.2";
	private String renderEngineName;
	private VersionInfo renderEngineVersion;
	private String renderEnginePluginVersion;
	private Map<String, AtomicInteger> representationItems = new HashMap<>();
	private GregorianCalendar start = new GregorianCalendar();
	private GregorianCalendar end;
	private String originalIfcFileName;
	private long originalIfcFileSize;
	private Schema ifcSchema;
	private String userName;
	private String userUserName;
	private int availableProcessors;
	private String originalDeserializer;
	private Set<ReportJob> jobs = new LinkedHashSet<>();
	private int maxObjectsPerFile;
	private boolean useMappingOptimization;
	private long numberOfObjects;
	private int numberOfTriangles;
	private int numberOfTrianglesIncludingReuse;
	private boolean reuseGeometry;
	private boolean calculateQuantities;
	private boolean applyLayersets;
	private final Map<Integer, String> debugFiles = new ConcurrentSkipListMap<>();
	private SkippedBecauseOfInvalidRepresentation skippedBecauseOfInvalidRepresentationIdentifier = new SkippedBecauseOfInvalidRepresentation();
	
	public synchronized void incrementTriangles(int triangles) {
		this.numberOfTriangles += triangles;
	}

	public void incrementTrianglesIncludingReuse(int triangles) {
		this.numberOfTrianglesIncludingReuse += triangles;
	}
	
	public void setRenderEngineName(String renderEngineName) {
		this.renderEngineName = renderEngineName;
	}
	
	public void setStart(GregorianCalendar start) {
		this.start = start;
	}
	
	public void setEnd(GregorianCalendar end) {
		this.end = end;
	}

	public void setRenderEnginePluginVersion(String renderEnginePluginVersion) {
		this.renderEnginePluginVersion = renderEnginePluginVersion;
	}

	public void setRenderEngineVersion(VersionInfo renderEngineVersion) {
		this.renderEngineVersion = renderEngineVersion;
	}

	public void addRepresentationItem(String name) {
		AtomicInteger atomicInteger = representationItems.get(name);
		if (atomicInteger == null) {
			atomicInteger = new AtomicInteger();
			representationItems.put(name, atomicInteger);
		}
		atomicInteger.incrementAndGet();
	}
	
	public void setIfcSchema(Schema ifcSchema) {
		this.ifcSchema = ifcSchema;
	}
	
	public void setOriginalIfcFileName(String originalIfcFileName) {
		this.originalIfcFileName = originalIfcFileName;
	}
	
	public void setOriginalIfcFileSize(long originalIfcFileSize) {
		this.originalIfcFileSize = originalIfcFileSize;
	}
	
	public ObjectNode toJson() {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode result = objectMapper.createObjectNode();
		
		ObjectNode renderEngine = objectMapper.createObjectNode();
		result.set("renderEngine", renderEngine);
		renderEngine.put("name", renderEngineName);
		renderEngine.set("version", renderEngineVersion.toJson());
		renderEngine.put("pluginVersion", renderEnginePluginVersion);
		
		ObjectNode ifcModel = objectMapper.createObjectNode();
		result.set("ifcModel", ifcModel);
		ifcModel.put("filename", originalIfcFileName);
		ifcModel.put("filesize", originalIfcFileSize);
		ifcModel.put("schema", ifcSchema.name());
		ifcModel.put("objects", numberOfObjects);
		ifcModel.put("triangles", numberOfTriangles);
		ifcModel.put("trianglesIncludingReuse", numberOfTrianglesIncludingReuse);
		
		ObjectNode user = objectMapper.createObjectNode();
		user.put("name", userName);
		user.put("username", userUserName);
		result.set("user", user);
		
		ObjectNode settings = objectMapper.createObjectNode();
		settings.put("maxObjectsPerFile", maxObjectsPerFile);
		settings.put("reuseGeometry", reuseGeometry);
		settings.put("useMappingOptimization", useMappingOptimization);
		result.set("settings", settings);

		ObjectNode engineSettings = objectMapper.createObjectNode();
		settings.put("applyLayersets", applyLayersets);
		settings.put("calculateQuantities", calculateQuantities);
		result.set("engineSettings", engineSettings);
		
		ObjectNode deserializer = objectMapper.createObjectNode();
		deserializer.put("name", originalDeserializer);
		result.set("deserializer", deserializer);
		
		ObjectNode system = objectMapper.createObjectNode();
		system.put("cores", availableProcessors);
		result.set("system", system);
		
		ArrayNode jobsArray = objectMapper.createArrayNode();
		result.set("jobs", jobsArray);
		for (ReportJob job : jobs) {
			ObjectNode jobNode = objectMapper.createObjectNode();
			jobNode.put("id", job.getId());
			jobNode.put("mainType", job.getMainType());
			
			ArrayNode objectsNode = objectMapper.createArrayNode();
			for (Long oid : job.getObjects().keySet()) {
				ObjectNode objectNode = objectMapper.createObjectNode();
				objectNode.put("oid", oid);
				objectNode.put("type", job.getObjects().get(oid));
				objectsNode.add(objectNode);
			}
			jobNode.set("objects", objectsNode);
			
			jobNode.put("nrObjects", job.getNrObjects());
			jobNode.put("usesMapping", job.isUsesMapping());
			jobNode.put("trianglesGenerated", job.getTrianglesGenerated());
			jobNode.put("totalTimeNanos", job.getTotalNanos());
			jobNode.put("cpuTimeMs", job.getCpuTimeMs());
			jobNode.put("maxMemoryBytes", job.getMaxMemoryBytes());
			
			if (job.getException() != null) {
				StringWriter writer = new StringWriter();
				job.getException().printStackTrace(new PrintWriter(writer));
				jobNode.put("exception", writer.toString());
			}
			
			jobsArray.add(jobNode);
		}
		
		ObjectNode processing = objectMapper.createObjectNode();
		result.set("processing", processing);
		processing.put("start", start.getTimeInMillis());
		processing.put("stop", end.getTimeInMillis());
		processing.put("totaltime", (end.getTimeInMillis() - start.getTimeInMillis()));
		
		ArrayNode geometry = objectMapper.createArrayNode();
		result.set("geometry", geometry);
		for (String type : representationItems.keySet()) {
			ObjectNode geometryNode = objectMapper.createObjectNode();
			geometryNode.put("type", type);
			geometryNode.put("count", representationItems.get(type).get());
			geometry.add(geometryNode);
		}

		ArrayNode skippedNodes = objectMapper.createArrayNode();
		for (String identifier : this.skippedBecauseOfInvalidRepresentationIdentifier.keySet()) {
			ObjectNode skippedNode = objectMapper.createObjectNode();
			skippedNode.put("identifier", identifier);
			skippedNode.put("skipped", this.skippedBecauseOfInvalidRepresentationIdentifier.get(identifier));
			skippedNodes.add(skippedNode);
		}
		result.set("skippedBecauseOfInvalidRepresentationIdentifier", skippedNodes);
		
		ArrayNode debugFiles = objectMapper.createArrayNode();
		result.set("debugFiles", debugFiles);
		for (int jobId : this.debugFiles.keySet()) {
			String filename = this.debugFiles.get(jobId);
			ObjectNode debugNode = objectMapper.createObjectNode();
			debugNode.put("id", jobId);
			debugNode.put("debugFile", filename);
			debugFiles.add(debugNode);
		}
		
		return result;
	}
	
	public String toHtml() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>BIMserver geometry generation report (v" + REPORT_VERSION + ")</h1>");
		
		builder.append("<h3>Render engine</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Render engine name</td><td>" + renderEngineName + "</td></tr>");
		builder.append("<tr><td>Render engine version platform</td><td>" + renderEngineVersion.getPlatform() + "</td></tr>");
		builder.append("<tr><td>Render engine version branch</td><td>" + renderEngineVersion.getBranch() + "</td></tr>");
		builder.append("<tr><td>Render engine version commitsha</td><td>" + renderEngineVersion.getCommitsha() + "</td></tr>");
		builder.append("<tr><td>Render engine version protocol</td><td>" + renderEngineVersion.getProtocolVersion() + "</td></tr>");
		builder.append("<tr><td>Render engine version date/time</td><td>" + dateFormat.format(renderEngineVersion.getDateTime().getTime()) + "</td></tr>");
		builder.append("<tr><td>Render engine plugin version</td><td>" + renderEnginePluginVersion + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>IFC Model</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>File name</td><td>" + originalIfcFileName + "</td></tr>");
		builder.append("<tr><td>File size</td><td>" + Formatters.bytesToString(originalIfcFileSize) + "</td></tr>");
		builder.append("<tr><td>Schema</td><td>" + ifcSchema + "</td></tr>");
		builder.append("<tr><td>Objects</td><td>" + numberOfObjects + "</td></tr>");
		builder.append("<tr><td>Triangles</td><td>" + numberOfTriangles + "</td></tr>");
		builder.append("<tr><td>Triangles including reuse</td><td>" + numberOfTrianglesIncludingReuse + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>User</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Name</td><td>" + userName + "</td></tr>");
		builder.append("<tr><td>Username</td><td>" + userUserName + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Settings</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Max objects per file</td><td>" + maxObjectsPerFile + "</td></tr>");
		builder.append("<tr><td>Reuse geometry</td><td>" + reuseGeometry + "</td></tr>");
		builder.append("<tr><td>Optimize mapped items</td><td>" + useMappingOptimization + "</td></tr>");
		builder.append("</tbody></table>");

		builder.append("<h3>Render engine settings</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Apply layer sets</td><td>" + applyLayersets + "</td></tr>");
		builder.append("<tr><td>Calculate quantities</td><td>" + calculateQuantities + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Deserializer</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Deserializer</td><td>" + originalDeserializer + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>System</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Available (virtual) cores</td><td>" + availableProcessors + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Skipped representatios</h3>");
		builder.append("<table>");
		builder.append("<thead><tr><th>Identifier</th><th>Skipped</th></tr></thead>");
		builder.append("<tbody>");
		for (String identifier : this.skippedBecauseOfInvalidRepresentationIdentifier.keySet()) {
			builder.append("<tr><td>" + identifier + "</td><td>" + this.skippedBecauseOfInvalidRepresentationIdentifier.get(identifier));
		}
		builder.append("</tbody></table>");
		
		builder.append("<h3>Jobs</h3>");
		builder.append("<table>");
		builder.append("<thead><tr><th>Main type</th><th># objects</th><th>Uses mapping</th><th># triangles</th><th>Total time</th><th>CPU time</th><th>Max memory</th><th>Exception</th><th>Debug file</th></tr></thead>");
		builder.append("<tbody>");
		for (ReportJob job : jobs) {
			builder.append("<tr>");
			builder.append("<td>" + job.getMainType() + "</td>");
			builder.append("<td>" + job.getNrObjects() + "</td>");
			builder.append("<td>" + job.isUsesMapping() + "</td>");
			builder.append("<td>" + job.getTrianglesGenerated() + "</td>");
//			builder.append("<td>");
//			Map<Long, String> objects = job.getObjects();
//			for (Long oid : objects.keySet()) {
//				String type = objects.get(oid);
//				builder.append(oid + "(" + type + "), ");
//			}
//			builder.append("</td>");
			builder.append("<td>" + Formatters.millisecondsToString(job.getTotalNanos() / 1000000) + "</td>");
			builder.append("<td>" + job.getCpuTimeMs() + "ms</td>");
			builder.append("<td>" + job.getMaxMemoryBytes() + "</td>");
			if (job.getException() != null) {
				StringWriter writer = new StringWriter();
				job.getException().printStackTrace(new PrintWriter(writer));
				builder.append("<td><pre>" + writer.toString() + "</pre></td>");
			} else {
				builder.append("<td>None</td>");
			}
			if (debugFiles.containsKey(job.getId())) {
				builder.append("<td><a href=\"#debug" + job.getId() + "\">" + job.getId() + "</a></td>");
			} else {
				builder.append("<td>None</td>");
			}
			builder.append("</tr>\n");
		}
		builder.append("</tbody></table>");

		builder.append("<h3>Processing</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Start</td><td>" + dateFormat.format(start.getTime()) + "</td></tr>");
		builder.append("<tr><td>Stop</td><td>" + dateFormat.format(end.getTime()) + "</td></tr>");
		builder.append("<tr><td>Total time</td><td>" + Formatters.millisecondsToString(end.getTimeInMillis() - start.getTimeInMillis()) + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Geometry</h3>");
		builder.append("<table>");
		builder.append("<thead><tr><th>Type</th><th>Used</th></tr></thead>");
		builder.append("<tbody>");
		for (String type : representationItems.keySet()) {
			builder.append("<tr>");
			builder.append("<td>" + type + "</td>");
			builder.append("<td>" + representationItems.get(type).get() + "</td>");
			builder.append("</tr>");
		}
		builder.append("</tbody></table>");

		builder.append("<h3>Debug files</h3>");
		builder.append("<table>");
		builder.append("<thead><tr><th>ID</th><th>Filename</th></tr></thead>");
		builder.append("<tbody>");
		for (int jobId : debugFiles.keySet()) {
			builder.append("<tr>");
			// NPE has happened here 23-11-2018
			builder.append("<td><a name=\"debug" + jobId + "\">" + jobId + "</a></td>");
			builder.append("<td>" + debugFiles.get(jobId) + "</td>");
			builder.append("</tr>");
		}
		builder.append("</tbody></table>");

//		builder.append("<h3>Triangles</h3>");
//		builder.append("<table>");
//		builder.append("<thead><tr><th>Type</th><th>Used</th></tr></thead>");
//		builder.append("<tbody>");
//		for (String type : representationItems.keySet()) {
//			builder.append("<tr>");
//			builder.append("<td>" + type + "</td>");
//			builder.append("<td>" + representationItems.get(type).get() + "</td>");
//			builder.append("</tr>");
//		}
//		builder.append("</tbody></table>");
		
		return builder.toString();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public void setAvailableProcessors(int availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public void setOriginalDeserializer(String originalDeserializer) {
		this.originalDeserializer = originalDeserializer;
	}

	public ReportJob newJob(String mainType, int nrObjects) {
		ReportJob job = new ReportJob(this, mainType, nrObjects);
		jobs.add(job);
		job.setId(jobs.size());
		return job;
	}

	public void setMaxPerFile(int maxObjectsPerFile) {
		this.maxObjectsPerFile = maxObjectsPerFile;
	}

	public void setUseMappingOptimization(boolean useMappingOptimization) {
		this.useMappingOptimization = useMappingOptimization;
	}

	public void setNumberOfObjects(long numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
	}

	public void setReuseGeometry(boolean reuseGeometry) {
		this.reuseGeometry = reuseGeometry;
	}
	
	public void addDebugFile(String filename, int id) {
		if (!debugFiles.containsKey(id)) {
			debugFiles.put(id, filename);
		}
	}
	
	public int getNumberOfTrianglesIncludingReuse() {
		return numberOfTrianglesIncludingReuse;
	}

	public int getNumberOfDebugFiles() {
		return debugFiles.size();
	}

	public SkippedBecauseOfInvalidRepresentation getSkippedBecauseOfInvalidRepresentationIdentifier() {
		return skippedBecauseOfInvalidRepresentationIdentifier;
	}
	
	public void addSkippedBecauseOfInvalidRepresentationIdentifier(String identifier) {
		skippedBecauseOfInvalidRepresentationIdentifier.merge(identifier, 1);
	}
	
	public String getOriginalIfcFileName() {
		return originalIfcFileName;
	}

	public boolean isCalculateQuantities() {
		return calculateQuantities;
	}

	public void setCalculateQuantities(boolean calculateQuantities) {
		this.calculateQuantities = calculateQuantities;
	}

	public boolean isApplyLayersets() {
		return applyLayersets;
	}

	public void setApplyLayersets(boolean applyLayersets) {
		this.applyLayersets = applyLayersets;
	}
	
	public GregorianCalendar getStart() {
		return start;
	}
	
	public GregorianCalendar getEnd() {
		return end;
	}
	
	public long getTimeToGenerateMs() {
		return end.getTimeInMillis() - start.getTimeInMillis();
	}
}