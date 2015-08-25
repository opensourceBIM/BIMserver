package org.bimserver.demoplugins.service.tco;

public class CellValue {

	private Object value;
	
	public CellValue(int value) {
		this.value = value;
	}

	public CellValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
