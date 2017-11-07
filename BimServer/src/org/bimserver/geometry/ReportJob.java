package org.bimserver.geometry;

import java.util.HashMap;
import java.util.Map;

public class ReportJob {

	private Map<Long, String> objects = new HashMap<>();
	private Exception exception;
	private long end;
	private long start;
	private String mainType;
	private int nrObjects;
	private boolean usesMapping;
	private int trianglesGenerated;
	private GeometryGenerationReport report;
	private int debugId = -1;
	
	public ReportJob(GeometryGenerationReport report, String mainType, int nrObjects) {
		this.report = report;
		this.mainType = mainType;
		this.nrObjects = nrObjects;
	}

	public String getMainType() {
		return mainType;
	}
	
	public void addObject(long oid, String name) {
		objects.put(oid, name);
	}

	public void setException(Exception exception, int debugId) {
		this.exception = exception;
		this.debugId = debugId;
	}
	
	public int getDebugId() {
		return debugId;
	}

	public void setEndNanos(long end) {
		this.end = end;
	}

	public void setStartNanos(long start) {
		this.start = start;
	}
	
	public long getTotalNanos() {
		return end - start;
	}
	
	public Map<Long, String> getObjects() {
		return objects;
	}
	
	public Exception getException() {
		return exception;
	}
	
	public int getNrObjects() {
		return nrObjects;
	}

	public void setUsesMapping(boolean usesMapping) {
		this.usesMapping = usesMapping;
	}
	
	public boolean isUsesMapping() {
		return usesMapping;
	}

	public void setTrianglesGenerated(int trianglesGenerated) {
		this.trianglesGenerated = trianglesGenerated;
	}
	
	public int getTrianglesGenerated() {
		return trianglesGenerated;
	}

	public GeometryGenerationReport getReport() {
		return report;
	}
}