package org.bimserver.database;

/**
 * 
 * @author Ruben de Laat
 *
 *	Always use READ_ONLY when the DatabaseSession will _only_ be reading, this will benefit performance
 *	Use READ_WRITE when the DatabaseSession will definitely try to write data
 *	Use POSSIBLY_WRITE for a DatabaseSession that might write, this will do exactly the same as READ_WRITE, except 
 *	it won't log any warnings about a READ_WRITE DatabaseSession that doesn't write anything 
 *
 */
public enum OperationType {
	READ_ONLY,
	READ_WRITE,
	POSSIBLY_WRITE
}
