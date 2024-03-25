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
 * A representation of the literals of the enumeration '<em><b>Ifc Earthworks Cut Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcEarthworksCutTypeEnum()
 * @model
 * @generated
 */
public enum IfcEarthworksCutTypeEnum implements Enumerator {
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
	 * The '<em><b>BASE EXCAVATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_EXCAVATION_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_EXCAVATION(1, "BASE_EXCAVATION", "BASE_EXCAVATION"),

	/**
	 * The '<em><b>EXCAVATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXCAVATION_VALUE
	 * @generated
	 * @ordered
	 */
	EXCAVATION(2, "EXCAVATION", "EXCAVATION"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>CUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUT_VALUE
	 * @generated
	 * @ordered
	 */
	CUT(4, "CUT", "CUT"),

	/**
	 * The '<em><b>DREDGING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DREDGING_VALUE
	 * @generated
	 * @ordered
	 */
	DREDGING(5, "DREDGING", "DREDGING"),

	/**
	 * The '<em><b>PAVEMENTMILLING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVEMENTMILLING_VALUE
	 * @generated
	 * @ordered
	 */
	PAVEMENTMILLING(6, "PAVEMENTMILLING", "PAVEMENTMILLING"),

	/**
	 * The '<em><b>TRENCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRENCH_VALUE
	 * @generated
	 * @ordered
	 */
	TRENCH(7, "TRENCH", "TRENCH"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(8, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>OVEREXCAVATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVEREXCAVATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVEREXCAVATION(9, "OVEREXCAVATION", "OVEREXCAVATION"),

	/**
	 * The '<em><b>STEPEXCAVATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEPEXCAVATION_VALUE
	 * @generated
	 * @ordered
	 */
	STEPEXCAVATION(10, "STEPEXCAVATION", "STEPEXCAVATION"),

	/**
	 * The '<em><b>TOPSOILREMOVAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPSOILREMOVAL_VALUE
	 * @generated
	 * @ordered
	 */
	TOPSOILREMOVAL(11, "TOPSOILREMOVAL", "TOPSOILREMOVAL");

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
	 * The '<em><b>BASE EXCAVATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_EXCAVATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASE_EXCAVATION_VALUE = 1;

	/**
	 * The '<em><b>EXCAVATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXCAVATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXCAVATION_VALUE = 2;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 3;

	/**
	 * The '<em><b>CUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUT_VALUE = 4;

	/**
	 * The '<em><b>DREDGING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DREDGING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DREDGING_VALUE = 5;

	/**
	 * The '<em><b>PAVEMENTMILLING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVEMENTMILLING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PAVEMENTMILLING_VALUE = 6;

	/**
	 * The '<em><b>TRENCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRENCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRENCH_VALUE = 7;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 8;

	/**
	 * The '<em><b>OVEREXCAVATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVEREXCAVATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OVEREXCAVATION_VALUE = 9;

	/**
	 * The '<em><b>STEPEXCAVATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEPEXCAVATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEPEXCAVATION_VALUE = 10;

	/**
	 * The '<em><b>TOPSOILREMOVAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPSOILREMOVAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOPSOILREMOVAL_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Earthworks Cut Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcEarthworksCutTypeEnum[] VALUES_ARRAY = new IfcEarthworksCutTypeEnum[] { NULL,
			BASE_EXCAVATION, EXCAVATION, NOTDEFINED, CUT, DREDGING, PAVEMENTMILLING, TRENCH, USERDEFINED,
			OVEREXCAVATION, STEPEXCAVATION, TOPSOILREMOVAL, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Earthworks Cut Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcEarthworksCutTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Earthworks Cut Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEarthworksCutTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEarthworksCutTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Earthworks Cut Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEarthworksCutTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEarthworksCutTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Earthworks Cut Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEarthworksCutTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case BASE_EXCAVATION_VALUE:
			return BASE_EXCAVATION;
		case EXCAVATION_VALUE:
			return EXCAVATION;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case CUT_VALUE:
			return CUT;
		case DREDGING_VALUE:
			return DREDGING;
		case PAVEMENTMILLING_VALUE:
			return PAVEMENTMILLING;
		case TRENCH_VALUE:
			return TRENCH;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case OVEREXCAVATION_VALUE:
			return OVEREXCAVATION;
		case STEPEXCAVATION_VALUE:
			return STEPEXCAVATION;
		case TOPSOILREMOVAL_VALUE:
			return TOPSOILREMOVAL;
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
	private IfcEarthworksCutTypeEnum(int value, String name, String literal) {
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

} //IfcEarthworksCutTypeEnum
