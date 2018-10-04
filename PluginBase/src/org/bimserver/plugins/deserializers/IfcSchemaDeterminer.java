package org.bimserver.plugins.deserializers;

import org.bimserver.emf.Schema;

public interface IfcSchemaDeterminer {
	/**
	 * @param head The initial x characters, should contain the full header section of the ifc step file
	 * @return The schema
	 */
	Schema determineSchema(byte[] head, boolean usesZip);
}
