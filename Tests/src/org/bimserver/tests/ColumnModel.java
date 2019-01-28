package org.bimserver.tests;

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

import java.util.Enumeration;

import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ColumnModel implements TableColumnModel {

	@Override
	public void addColumn(TableColumn column) {
	}

	@Override
	public void addColumnModelListener(TableColumnModelListener x) {
	}

	@Override
	public TableColumn getColumn(int columnIndex) {
		return null;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public int getColumnIndex(Object columnIdentifier) {
		return 0;
	}

	@Override
	public int getColumnIndexAtX(int position) {
		return 0;
	}

	@Override
	public int getColumnMargin() {
		return 0;
	}

	@Override
	public boolean getColumnSelectionAllowed() {
		return false;
	}

	@Override
	public Enumeration<TableColumn> getColumns() {
		return null;
	}

	@Override
	public int getSelectedColumnCount() {
		return 0;
	}

	@Override
	public int[] getSelectedColumns() {
		return null;
	}

	@Override
	public ListSelectionModel getSelectionModel() {
		return null;
	}

	@Override
	public int getTotalColumnWidth() {
		return 0;
	}

	@Override
	public void moveColumn(int columnIndex, int newIndex) {
	}

	@Override
	public void removeColumn(TableColumn column) {
	}

	@Override
	public void removeColumnModelListener(TableColumnModelListener x) {
	}

	@Override
	public void setColumnMargin(int newMargin) {
	}

	@Override
	public void setColumnSelectionAllowed(boolean flag) {
	}

	@Override
	public void setSelectionModel(ListSelectionModel newModel) {
	}

}
