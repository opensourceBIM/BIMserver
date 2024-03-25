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
 * A representation of the literals of the enumeration '<em><b>Ifc Covering Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCoveringTypeEnum()
 * @model
 * @generated
 */
public enum IfcCoveringTypeEnum implements Enumerator {
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
	 * The '<em><b>TOPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPPING_VALUE
	 * @generated
	 * @ordered
	 */
	TOPPING(1, "TOPPING", "TOPPING"),

	/**
	 * The '<em><b>WRAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	WRAPPING(2, "WRAPPING", "WRAPPING"),

	/**
	 * The '<em><b>MEMBRANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBRANE_VALUE
	 * @generated
	 * @ordered
	 */
	MEMBRANE(3, "MEMBRANE", "MEMBRANE"),

	/**
	 * The '<em><b>ROOFING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROOFING_VALUE
	 * @generated
	 * @ordered
	 */
	ROOFING(4, "ROOFING", "ROOFING"),

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
	 * The '<em><b>SLEEVING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLEEVING_VALUE
	 * @generated
	 * @ordered
	 */
	SLEEVING(6, "SLEEVING", "SLEEVING"),

	/**
	 * The '<em><b>FLOORING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOORING_VALUE
	 * @generated
	 * @ordered
	 */
	FLOORING(7, "FLOORING", "FLOORING"),

	/**
	 * The '<em><b>COPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPING_VALUE
	 * @generated
	 * @ordered
	 */
	COPING(8, "COPING", "COPING"),

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
	 * The '<em><b>SKIRTINGBOARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKIRTINGBOARD_VALUE
	 * @generated
	 * @ordered
	 */
	SKIRTINGBOARD(10, "SKIRTINGBOARD", "SKIRTINGBOARD"),

	/**
	 * The '<em><b>CEILING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CEILING_VALUE
	 * @generated
	 * @ordered
	 */
	CEILING(11, "CEILING", "CEILING"),

	/**
	 * The '<em><b>MOLDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLDING_VALUE
	 * @generated
	 * @ordered
	 */
	MOLDING(12, "MOLDING", "MOLDING"),

	/**
	 * The '<em><b>INSULATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSULATION_VALUE
	 * @generated
	 * @ordered
	 */
	INSULATION(13, "INSULATION", "INSULATION"),

	/**
	 * The '<em><b>CLADDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLADDING_VALUE
	 * @generated
	 * @ordered
	 */
	CLADDING(14, "CLADDING", "CLADDING");

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
	 * The '<em><b>TOPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPPING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOPPING_VALUE = 1;

	/**
	 * The '<em><b>WRAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRAPPING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WRAPPING_VALUE = 2;

	/**
	 * The '<em><b>MEMBRANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBRANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEMBRANE_VALUE = 3;

	/**
	 * The '<em><b>ROOFING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROOFING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROOFING_VALUE = 4;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 5;

	/**
	 * The '<em><b>SLEEVING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLEEVING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLEEVING_VALUE = 6;

	/**
	 * The '<em><b>FLOORING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOORING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOORING_VALUE = 7;

	/**
	 * The '<em><b>COPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COPING_VALUE = 8;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 9;

	/**
	 * The '<em><b>SKIRTINGBOARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKIRTINGBOARD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SKIRTINGBOARD_VALUE = 10;

	/**
	 * The '<em><b>CEILING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CEILING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CEILING_VALUE = 11;

	/**
	 * The '<em><b>MOLDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOLDING_VALUE = 12;

	/**
	 * The '<em><b>INSULATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSULATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSULATION_VALUE = 13;

	/**
	 * The '<em><b>CLADDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLADDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLADDING_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Covering Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCoveringTypeEnum[] VALUES_ARRAY = new IfcCoveringTypeEnum[] { NULL, TOPPING, WRAPPING,
			MEMBRANE, ROOFING, USERDEFINED, SLEEVING, FLOORING, COPING, NOTDEFINED, SKIRTINGBOARD, CEILING, MOLDING,
			INSULATION, CLADDING, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Covering Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCoveringTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Covering Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoveringTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCoveringTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Covering Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoveringTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCoveringTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Covering Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoveringTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case TOPPING_VALUE:
			return TOPPING;
		case WRAPPING_VALUE:
			return WRAPPING;
		case MEMBRANE_VALUE:
			return MEMBRANE;
		case ROOFING_VALUE:
			return ROOFING;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case SLEEVING_VALUE:
			return SLEEVING;
		case FLOORING_VALUE:
			return FLOORING;
		case COPING_VALUE:
			return COPING;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case SKIRTINGBOARD_VALUE:
			return SKIRTINGBOARD;
		case CEILING_VALUE:
			return CEILING;
		case MOLDING_VALUE:
			return MOLDING;
		case INSULATION_VALUE:
			return INSULATION;
		case CLADDING_VALUE:
			return CLADDING;
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
	private IfcCoveringTypeEnum(int value, String name, String literal) {
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

} //IfcCoveringTypeEnum
