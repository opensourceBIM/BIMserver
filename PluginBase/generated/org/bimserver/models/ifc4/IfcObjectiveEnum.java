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
package org.bimserver.models.ifc4;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Objective Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectiveEnum()
 * @model
 * @generated
 */
public enum IfcObjectiveEnum implements Enumerator {
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
	 * The '<em><b>HEALTHANDSAFETY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEALTHANDSAFETY_VALUE
	 * @generated
	 * @ordered
	 */
	HEALTHANDSAFETY(1, "HEALTHANDSAFETY", "HEALTHANDSAFETY"),

	/**
	 * The '<em><b>MODELVIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODELVIEW_VALUE
	 * @generated
	 * @ordered
	 */
	MODELVIEW(2, "MODELVIEW", "MODELVIEW"),

	/**
	 * The '<em><b>MERGECONFLICT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERGECONFLICT_VALUE
	 * @generated
	 * @ordered
	 */
	MERGECONFLICT(3, "MERGECONFLICT", "MERGECONFLICT"),

	/**
	 * The '<em><b>TRIGGERCONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIGGERCONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	TRIGGERCONDITION(4, "TRIGGERCONDITION", "TRIGGERCONDITION"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(5, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SPECIFICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFICATION(6, "SPECIFICATION", "SPECIFICATION"),

	/**
	 * The '<em><b>CODECOMPLIANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CODECOMPLIANCE_VALUE
	 * @generated
	 * @ordered
	 */
	CODECOMPLIANCE(7, "CODECOMPLIANCE", "CODECOMPLIANCE"),

	/**
	 * The '<em><b>CODEWAIVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CODEWAIVER_VALUE
	 * @generated
	 * @ordered
	 */
	CODEWAIVER(8, "CODEWAIVER", "CODEWAIVER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(9, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>EXTERNAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERNAL(10, "EXTERNAL", "EXTERNAL"),

	/**
	 * The '<em><b>DESIGNINTENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESIGNINTENT_VALUE
	 * @generated
	 * @ordered
	 */
	DESIGNINTENT(11, "DESIGNINTENT", "DESIGNINTENT"),

	/**
	 * The '<em><b>PARAMETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETER(12, "PARAMETER", "PARAMETER"),

	/**
	 * The '<em><b>REQUIREMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENT_VALUE
	 * @generated
	 * @ordered
	 */
	REQUIREMENT(13, "REQUIREMENT", "REQUIREMENT");

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
	 * The '<em><b>HEALTHANDSAFETY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEALTHANDSAFETY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEALTHANDSAFETY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEALTHANDSAFETY_VALUE = 1;

	/**
	 * The '<em><b>MODELVIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODELVIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODELVIEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODELVIEW_VALUE = 2;

	/**
	 * The '<em><b>MERGECONFLICT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MERGECONFLICT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MERGECONFLICT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MERGECONFLICT_VALUE = 3;

	/**
	 * The '<em><b>TRIGGERCONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIGGERCONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIGGERCONDITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGERCONDITION_VALUE = 4;

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
	public static final int USERDEFINED_VALUE = 5;

	/**
	 * The '<em><b>SPECIFICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIFICATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIFICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFICATION_VALUE = 6;

	/**
	 * The '<em><b>CODECOMPLIANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CODECOMPLIANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CODECOMPLIANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CODECOMPLIANCE_VALUE = 7;

	/**
	 * The '<em><b>CODEWAIVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CODEWAIVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CODEWAIVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CODEWAIVER_VALUE = 8;

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
	public static final int NOTDEFINED_VALUE = 9;

	/**
	 * The '<em><b>EXTERNAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXTERNAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNAL_VALUE = 10;

	/**
	 * The '<em><b>DESIGNINTENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DESIGNINTENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGNINTENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DESIGNINTENT_VALUE = 11;

	/**
	 * The '<em><b>PARAMETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARAMETER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_VALUE = 12;

	/**
	 * The '<em><b>REQUIREMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REQUIREMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REQUIREMENT_VALUE = 13;

	/**
	 * An array of all the '<em><b>Ifc Objective Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcObjectiveEnum[] VALUES_ARRAY = new IfcObjectiveEnum[] { NULL, HEALTHANDSAFETY, MODELVIEW, MERGECONFLICT, TRIGGERCONDITION, USERDEFINED, SPECIFICATION, CODECOMPLIANCE, CODEWAIVER, NOTDEFINED, EXTERNAL,
			DESIGNINTENT, PARAMETER, REQUIREMENT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Objective Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcObjectiveEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Objective Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcObjectiveEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcObjectiveEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Objective Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcObjectiveEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcObjectiveEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Objective Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcObjectiveEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case HEALTHANDSAFETY_VALUE:
			return HEALTHANDSAFETY;
		case MODELVIEW_VALUE:
			return MODELVIEW;
		case MERGECONFLICT_VALUE:
			return MERGECONFLICT;
		case TRIGGERCONDITION_VALUE:
			return TRIGGERCONDITION;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case SPECIFICATION_VALUE:
			return SPECIFICATION;
		case CODECOMPLIANCE_VALUE:
			return CODECOMPLIANCE;
		case CODEWAIVER_VALUE:
			return CODEWAIVER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case EXTERNAL_VALUE:
			return EXTERNAL;
		case DESIGNINTENT_VALUE:
			return DESIGNINTENT;
		case PARAMETER_VALUE:
			return PARAMETER;
		case REQUIREMENT_VALUE:
			return REQUIREMENT;
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
	private IfcObjectiveEnum(int value, String name, String literal) {
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

} //IfcObjectiveEnum
