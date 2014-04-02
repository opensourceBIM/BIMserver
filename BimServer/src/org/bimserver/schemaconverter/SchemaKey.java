package org.bimserver.schemaconverter;

import org.bimserver.emf.Schema;

class SchemaKey {
	public Schema source;
	public Schema target;
	
	public SchemaKey(Schema source, Schema target) {
		this.source = source;
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		SchemaKey other = (SchemaKey) obj;
		if (source != other.source)
			return false;
		if (target != other.target)
			return false;
		return true;
	}
}