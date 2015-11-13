/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Task Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTypeEnum()
 * @model
 * @generated
 */
public enum IfcTaskTypeEnum implements Enumerator {
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
	 * The '<em><b>CONSTRUCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTION_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTRUCTION(1, "CONSTRUCTION", "CONSTRUCTION"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>MAINTENANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAINTENANCE_VALUE
	 * @generated
	 * @ordered
	 */
	MAINTENANCE(3, "MAINTENANCE", "MAINTENANCE"),

	/**
	 * The '<em><b>LOGISTIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGISTIC_VALUE
	 * @generated
	 * @ordered
	 */
	LOGISTIC(4, "LOGISTIC", "LOGISTIC"),

	/**
	 * The '<em><b>MOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE(5, "MOVE", "MOVE"),

	/**
	 * The '<em><b>REMOVAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVAL_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVAL(6, "REMOVAL", "REMOVAL"),

	/**
	 * The '<em><b>DISMANTLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISMANTLE_VALUE
	 * @generated
	 * @ordered
	 */
	DISMANTLE(7, "DISMANTLE", "DISMANTLE"),

	/**
	 * The '<em><b>DEMOLITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEMOLITION_VALUE
	 * @generated
	 * @ordered
	 */
	DEMOLITION(8, "DEMOLITION", "DEMOLITION"),

	/**
	 * The '<em><b>INSTALLATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTALLATION_VALUE
	 * @generated
	 * @ordered
	 */
	INSTALLATION(9, "INSTALLATION", "INSTALLATION"),

	/**
	 * The '<em><b>ATTENDANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTENDANCE_VALUE
	 * @generated
	 * @ordered
	 */
	ATTENDANCE(10, "ATTENDANCE", "ATTENDANCE"),

	/**
	 * The '<em><b>OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	OPERATION(11, "OPERATION", "OPERATION"),

	/**
	 * The '<em><b>DISPOSAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISPOSAL_VALUE
	 * @generated
	 * @ordered
	 */
	DISPOSAL(12, "DISPOSAL", "DISPOSAL"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(13, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>RENOVATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENOVATION_VALUE
	 * @generated
	 * @ordered
	 */
	RENOVATION(14, "RENOVATION", "RENOVATION");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>CONSTRUCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTRUCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRUCTION_VALUE = 1;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>MAINTENANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAINTENANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAINTENANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAINTENANCE_VALUE = 3;

	/**
	 * The '<em><b>LOGISTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOGISTIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGISTIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOGISTIC_VALUE = 4;

	/**
	 * The '<em><b>MOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_VALUE = 5;

	/**
	 * The '<em><b>REMOVAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REMOVAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVAL_VALUE = 6;

	/**
	 * The '<em><b>DISMANTLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISMANTLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISMANTLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISMANTLE_VALUE = 7;

	/**
	 * The '<em><b>DEMOLITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEMOLITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEMOLITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEMOLITION_VALUE = 8;

	/**
	 * The '<em><b>INSTALLATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTALLATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTALLATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSTALLATION_VALUE = 9;

	/**
	 * The '<em><b>ATTENDANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTENDANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTENDANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATTENDANCE_VALUE = 10;

	/**
	 * The '<em><b>OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_VALUE = 11;

	/**
	 * The '<em><b>DISPOSAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISPOSAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISPOSAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISPOSAL_VALUE = 12;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 13;

	/**
	 * The '<em><b>RENOVATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RENOVATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RENOVATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RENOVATION_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Task Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcTaskTypeEnum[] VALUES_ARRAY = new IfcTaskTypeEnum[] { NULL, CONSTRUCTION, NOTDEFINED,
			MAINTENANCE, LOGISTIC, MOVE, REMOVAL, DISMANTLE, DEMOLITION, INSTALLATION, ATTENDANCE, OPERATION, DISPOSAL,
			USERDEFINED, RENOVATION, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Task Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcTaskTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Task Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTaskTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcTaskTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Task Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTaskTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcTaskTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Task Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTaskTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case CONSTRUCTION_VALUE:
			return CONSTRUCTION;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case MAINTENANCE_VALUE:
			return MAINTENANCE;
		case LOGISTIC_VALUE:
			return LOGISTIC;
		case MOVE_VALUE:
			return MOVE;
		case REMOVAL_VALUE:
			return REMOVAL;
		case DISMANTLE_VALUE:
			return DISMANTLE;
		case DEMOLITION_VALUE:
			return DEMOLITION;
		case INSTALLATION_VALUE:
			return INSTALLATION;
		case ATTENDANCE_VALUE:
			return ATTENDANCE;
		case OPERATION_VALUE:
			return OPERATION;
		case DISPOSAL_VALUE:
			return DISPOSAL;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case RENOVATION_VALUE:
			return RENOVATION;
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
	private IfcTaskTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

} //IfcTaskTypeEnum
