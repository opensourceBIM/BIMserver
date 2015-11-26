package org.bimserver.database.queries.om;

public abstract class PartOfQuery {

	abstract void dump(int indent, StringBuilder sb);
	
	protected String indent(int indentation) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<indentation; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		dump(0, sb);
		return sb.toString();
	}
}