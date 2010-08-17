package org.bimserver.citygml.objects;

import ade.ColumnType;

public class Column extends VisualElement {

	public Column(ColumnType columnType) {
		super(columnType);
	}

	public Column() {
		this(new ColumnType());
	}

	public ColumnType getJAXBObject() {
		return (ColumnType) visualElement;
	}
}