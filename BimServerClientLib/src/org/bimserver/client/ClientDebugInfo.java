package org.bimserver.client;

public class ClientDebugInfo {

	private int downloadData = 0;
	private int geometryDownload;
	private int getAll;
	private int guid;
	private int expl;
	
	public void incrementGetDownloadData() {
		downloadData++;
	}

	public void dump() {
		System.out.println("Download data: " + downloadData);
		System.out.println("Geometry download data: " + geometryDownload);
		System.out.println("Get all: " + getAll);
		System.out.println("Guid: " + guid);
		System.out.println("Explicit: " + expl);
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
