/**
 * 
 */
package org.bimserver.ifcengine;

/**
 * @author Peter Willems
 * 
 */
public enum SdaiTypes {
	NULL, ADB, AGGR, BINARY, BOOLEAN, ENUM, INSTANCE, INTEGER, LOGICAL, REAL, STRING;

	@Override
	public String toString() {
		return "sdai" + name();
	}

}
