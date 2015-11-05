package org.bimserver.ifc.step.deserializer;

public class MetricCollector {

	private long totalLineLength = 0;
	private long totalBytes = 0;
	
	public void collect(int length, int nrBytes) {
		totalLineLength += length;
		totalBytes += nrBytes;
	}
	
	public int estimateRequiredBytes(int lineLength) {
		if (totalLineLength == 0) {
			return lineLength;
		}
		return (int)(lineLength * totalBytes * 1.1 / totalLineLength);
	}
}