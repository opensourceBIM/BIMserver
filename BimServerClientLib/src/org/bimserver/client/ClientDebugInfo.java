package org.bimserver.client;

public class ClientDebugInfo {

	private int downloadData = 0;
	
	public void incrementGetDownloadData() {
		downloadData++;
	}

	public void dump() {
		System.out.println("Download data: " + downloadData);
	}
}
