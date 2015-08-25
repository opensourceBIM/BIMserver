package org.bimserver.demoplugins.service.tco;

public class CellKey {
	private int col;
	private int row;
	private String idString;

	public CellKey(int row, int col) {
		this.row = row;
		this.col = col;
		this.idString = String.format("R%sC%s", row, col);
	}
	
	public String getIdString() {
		return idString;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellKey other = (CellKey) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}