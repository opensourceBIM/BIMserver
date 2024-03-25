/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Bridge Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBridgeTypeEnum()
 * @model
 * @generated
 */
public enum IfcBridgeTypeEnum implements Enumerator {
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NULL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>SUSPENSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSION_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENSION(1, "SUSPENSION", "SUSPENSION"),

	/**
	 * The '<em><b>TRUSS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUSS_VALUE
	 * @generated
	 * @ordered
	 */
	TRUSS(2, "TRUSS", "TRUSS"),

	/**
	 * The '<em><b>GIRDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER_VALUE
	 * @generated
	 * @ordered
	 */
	GIRDER(3, "GIRDER", "GIRDER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>CANTILEVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANTILEVER_VALUE
	 * @generated
	 * @ordered
	 */
	CANTILEVER(5, "CANTILEVER", "CANTILEVER"),

	/**
	 * The '<em><b>FRAMEWORK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAMEWORK_VALUE
	 * @generated
	 * @ordered
	 */
	FRAMEWORK(6, "FRAMEWORK", "FRAMEWORK"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(7, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ARCHED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHED_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHED(8, "ARCHED", "ARCHED"),

	/**
	 * The '<em><b>CABLE STAYED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CABLE_STAYED_VALUE
	 * @generated
	 * @ordered
	 */
	CABLE_STAYED(9, "CABLE_STAYED", "CABLE_STAYED"),

	/**
	 * The '<em><b>CULVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CULVERT_VALUE
	 * @generated
	 * @ordered
	 */
	CULVERT(10, "CULVERT", "CULVERT");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>SUSPENSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENSION_VALUE = 1;

	/**
	 * The '<em><b>TRUSS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUSS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRUSS_VALUE = 2;

	/**
	 * The '<em><b>GIRDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIRDER_VALUE = 3;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 4;

	/**
	 * The '<em><b>CANTILEVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANTILEVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CANTILEVER_VALUE = 5;

	/**
	 * The '<em><b>FRAMEWORK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAMEWORK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRAMEWORK_VALUE = 6;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 7;

	/**
	 * The '<em><b>ARCHED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCHED_VALUE = 8;

	/**
	 * The '<em><b>CABLE STAYED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CABLE_STAYED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CABLE_STAYED_VALUE = 9;

	/**
	 * The '<em><b>CULVERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CULVERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CULVERT_VALUE = 10;

	/**
	 * An array of all the '<em><b>Ifc Bridge Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBridgeTypeEnum[] VALUES_ARRAY = new IfcBridgeTypeEnum[] { NULL, SUSPENSION, TRUSS, GIRDER,
			NOTDEFINED, CANTILEVER, FRAMEWORK, USERDEFINED, ARCHED, CABLE_STAYED, CULVERT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Bridge Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBridgeTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Bridge Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgeTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBridgeTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Bridge Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgeTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBridgeTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Bridge Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgeTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SUSPENSION_VALUE:
			return SUSPENSION;
		case TRUSS_VALUE:
			return TRUSS;
		case GIRDER_VALUE:
			return GIRDER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case CANTILEVER_VALUE:
			return CANTILEVER;
		case FRAMEWORK_VALUE:
			return FRAMEWORK;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ARCHED_VALUE:
			return ARCHED;
		case CABLE_STAYED_VALUE:
			return CABLE_STAYED;
		case CULVERT_VALUE:
			return CULVERT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IfcBridgeTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //IfcBridgeTypeEnum
