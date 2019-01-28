package org.bimserver.client;

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

public class ClientDebugInfo {

	private int downloadData = 0;
	private int geometryDownload;
	private int getAll;
	private int guid;
	private int expl;
	private long bytesOverTheLine = 0;
	
	public void incrementGetDownloadData() {
		downloadData++;
	}
	
	public void incBytesOverTheLine(long bytes) {
		this.bytesOverTheLine += bytes;
	}

	public void dump() {
//		System.out.println("Download data: " + downloadData);
//		System.out.println("Geometry download data: " + geometryDownload);
//		System.out.println("Get all: " + getAll);
//		System.out.println("Guid: " + guid);
//		System.out.println("Explicit: " + expl);
		System.out.println("Bytes over the line: " + bytesOverTheLine);
	}

	public void incrementGeometryGetDownloadData() {
		geometryDownload++;
	}

	public void incrementGetAll() {
		getAll++;
	}

	public void incGuid() {
		guid++;
	}

	public void incExplicit() {
		expl++;
	}
}
