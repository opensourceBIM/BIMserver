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

import java.util.HashMap;
import java.util.Map;

public class ReportJob {

	private Map<Long, String> objects = new HashMap<>();
	private Exception exception;
	private long end;
	private long start;
	private long cpuTimeMs;
	private String mainType;
	private int nrObjects;
	private boolean usesMapping;
	private int trianglesGenerated;
	private GeometryGenerationReport report;
	private int id;
	private long maxMemoryBytes;
	
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

	public void setException(Exception exception) {
		this.exception = exception;
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

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public long getCpuTimeMs() {
		return cpuTimeMs;
	}

	public void setCpuTimeMs(long cpuTimeMs) {
		this.cpuTimeMs = cpuTimeMs;
	}

	public void setMaxMemoryBytes(long maxMemoryBytes) {
		this.maxMemoryBytes = maxMemoryBytes;
	}
	
	public long getMaxMemoryBytes() {
		return maxMemoryBytes;
	}
}