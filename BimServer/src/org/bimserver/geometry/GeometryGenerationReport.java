package org.bimserver.geometry;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.bimserver.emf.Schema;
import org.bimserver.utils.Formatters;

public class GeometryGenerationReport {

	private static final String REPORT_VERSION = "1.0";
	private String renderEngineName;
	private String renderEngineVersion;
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
	private boolean reuseGeometry;
	private List<String> debugFiles = new ArrayList<>();
	
	public void incrementTriangles(int triangles) {
		this.numberOfTriangles += triangles;
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

	public void setRenderEngineVersion(String renderEngineVersion) {
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
	
	public String toHtml() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>BIMserver geometry generation report (v" + REPORT_VERSION + ")</h1>");
		
		builder.append("<h3>Render engine</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Render engine name</td><td>" + renderEngineName + "</td></tr>");
		builder.append("<tr><td>Render engine version</td><td>" + renderEngineVersion + "</td></tr>");
		builder.append("<tr><td>Render engine plugin version</td><td>" + renderEnginePluginVersion + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>IFC Model</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>File name</td><td>" + originalIfcFileName + "</td></tr>");
		builder.append("<tr><td>File size</td><td>" + Formatters.bytesToString(originalIfcFileSize) + "</td></tr>");
		builder.append("<tr><td>Schema</td><td>" + ifcSchema + "</td></tr>");
		builder.append("<tr><td>Objects</td><td>" + numberOfObjects + "</td></tr>");
		builder.append("<tr><td>Triangles</td><td>" + numberOfTriangles + "</td></tr>");
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
		builder.append("<tr><td>Using mapping optimization</td><td>" + useMappingOptimization + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Deserializer</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Deserializer</td><td>" + originalDeserializer + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>System</h3>");
		builder.append("<table><tbody>");
		builder.append("<tr><td>Available (virtual) cores</td><td>" + availableProcessors + "</td></tr>");
		builder.append("</tbody></table>");
		
		builder.append("<h3>Jobs</h3>");
		builder.append("<table>");
		builder.append("<thead><tr><th>Main type</th><th># objects</th><th>Uses mapping</th><th># triangles</th><th>Total time</th><th>Exception</th><th>Debug file</th></tr></thead>");
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
			if (job.getException() != null) {
				StringWriter writer = new StringWriter();
				job.getException().printStackTrace(new PrintWriter(writer));
				builder.append("<td><pre>" + writer.toString() + "</pre></td>");
			} else {
				builder.append("<td>None</td>");
			}
			if (job.getDebugId() != -1) {
				builder.append("<td><a href=\"#debug" + job.getDebugId() + "\">" + job.getDebugId() + "</a></td>");
			} else {
				builder.append("<td></td>");
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
		for (int i=1; i<=debugFiles.size(); i++) {
			builder.append("<tr>");
			builder.append("<td><a name=\"debug" + i + "\">" + i + "</a></td>");
			builder.append("<td>" + debugFiles.get(i - 1) + "</td>");
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
	
	public int addDebugFile(String filename) {
		debugFiles.add(filename);
		return debugFiles.size();
	}
}