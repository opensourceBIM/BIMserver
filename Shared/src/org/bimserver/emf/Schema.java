package org.bimserver.emf;

public enum Schema {
	STORE("STORE"),
	GEOMETRY("GEOMETRY"),
	LOG("LOG"),
	IFC2X3TC1("IFC2X3"),
	IFC4("IFC4");
	
	private String headerName;

	Schema(String headerName) {
		this.headerName = headerName;
	}
	
	public String getHeaderName() {
		return headerName;
	}
}