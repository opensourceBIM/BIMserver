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
package org.bimserver.models.ifc2x3tc1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Analysis Theory Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAnalysisTheoryTypeEnum()
 * @model
 * @generated
 */
public enum IfcAnalysisTheoryTypeEnum implements Enumerator {
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
	 * The '<em><b>FULL NONLINEAR THEORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULL_NONLINEAR_THEORY_VALUE
	 * @generated
	 * @ordered
	 */
	FULL_NONLINEAR_THEORY(1, "FULL_NONLINEAR_THEORY", "FULL_NONLINEAR_THEORY"),

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
	 * The '<em><b>THIRD ORDER THEORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THIRD_ORDER_THEORY_VALUE
	 * @generated
	 * @ordered
	 */
	THIRD_ORDER_THEORY(3, "THIRD_ORDER_THEORY", "THIRD_ORDER_THEORY"),

	/**
	 * The '<em><b>FIRST ORDER THEORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_ORDER_THEORY_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_ORDER_THEORY(4, "FIRST_ORDER_THEORY", "FIRST_ORDER_THEORY"),

	/**
	 * The '<em><b>SECOND ORDER THEORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_ORDER_THEORY_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_ORDER_THEORY(5, "SECOND_ORDER_THEORY", "SECOND_ORDER_THEORY"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(6, "USERDEFINED", "USERDEFINED");

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
	 * The '<em><b>FULL NONLINEAR THEORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FULL NONLINEAR THEORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FULL_NONLINEAR_THEORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FULL_NONLINEAR_THEORY_VALUE = 1;

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
	 * The '<em><b>THIRD ORDER THEORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THIRD ORDER THEORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THIRD_ORDER_THEORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THIRD_ORDER_THEORY_VALUE = 3;

	/**
	 * The '<em><b>FIRST ORDER THEORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRST ORDER THEORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_ORDER_THEORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_ORDER_THEORY_VALUE = 4;

	/**
	 * The '<em><b>SECOND ORDER THEORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECOND ORDER THEORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_ORDER_THEORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_ORDER_THEORY_VALUE = 5;

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
	public static final int USERDEFINED_VALUE = 6;

	/**
	 * An array of all the '<em><b>Ifc Analysis Theory Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcAnalysisTheoryTypeEnum[] VALUES_ARRAY = new IfcAnalysisTheoryTypeEnum[] { NULL, FULL_NONLINEAR_THEORY, NOTDEFINED, THIRD_ORDER_THEORY,
			FIRST_ORDER_THEORY, SECOND_ORDER_THEORY, USERDEFINED, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Analysis Theory Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcAnalysisTheoryTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Analysis Theory Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAnalysisTheoryTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAnalysisTheoryTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Analysis Theory Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAnalysisTheoryTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAnalysisTheoryTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Analysis Theory Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAnalysisTheoryTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case FULL_NONLINEAR_THEORY_VALUE:
			return FULL_NONLINEAR_THEORY;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case THIRD_ORDER_THEORY_VALUE:
			return THIRD_ORDER_THEORY;
		case FIRST_ORDER_THEORY_VALUE:
			return FIRST_ORDER_THEORY;
		case SECOND_ORDER_THEORY_VALUE:
			return SECOND_ORDER_THEORY;
		case USERDEFINED_VALUE:
			return USERDEFINED;
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
	private IfcAnalysisTheoryTypeEnum(int value, String name, String literal) {
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

} //IfcAnalysisTheoryTypeEnum
