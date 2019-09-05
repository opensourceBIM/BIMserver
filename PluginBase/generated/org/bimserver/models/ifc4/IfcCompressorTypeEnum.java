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
 * A representation of the literals of the enumeration '<em><b>Ifc Compressor Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCompressorTypeEnum()
 * @model
 * @generated
 */
public enum IfcCompressorTypeEnum implements Enumerator {
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
	 * The '<em><b>TWINSCREW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWINSCREW_VALUE
	 * @generated
	 * @ordered
	 */
	TWINSCREW(1, "TWINSCREW", "TWINSCREW"),

	/**
	 * The '<em><b>SINGLESCREW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLESCREW_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLESCREW(2, "SINGLESCREW", "SINGLESCREW"),

	/**
	 * The '<em><b>SINGLESTAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLESTAGE_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLESTAGE(3, "SINGLESTAGE", "SINGLESTAGE"),

	/**
	 * The '<em><b>RECIPROCATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECIPROCATING_VALUE
	 * @generated
	 * @ordered
	 */
	RECIPROCATING(4, "RECIPROCATING", "RECIPROCATING"),

	/**
	 * The '<em><b>TROCHOIDAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TROCHOIDAL_VALUE
	 * @generated
	 * @ordered
	 */
	TROCHOIDAL(5, "TROCHOIDAL", "TROCHOIDAL"),

	/**
	 * The '<em><b>OPENTYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPENTYPE_VALUE
	 * @generated
	 * @ordered
	 */
	OPENTYPE(6, "OPENTYPE", "OPENTYPE"),

	/**
	 * The '<em><b>ROTARYVANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARYVANE_VALUE
	 * @generated
	 * @ordered
	 */
	ROTARYVANE(7, "ROTARYVANE", "ROTARYVANE"),

	/**
	 * The '<em><b>SEMIHERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEMIHERMETIC_VALUE
	 * @generated
	 * @ordered
	 */
	SEMIHERMETIC(8, "SEMIHERMETIC", "SEMIHERMETIC"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>HERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERMETIC_VALUE
	 * @generated
	 * @ordered
	 */
	HERMETIC(10, "HERMETIC", "HERMETIC"),

	/**
	 * The '<em><b>DYNAMIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC_VALUE
	 * @generated
	 * @ordered
	 */
	DYNAMIC(11, "DYNAMIC", "DYNAMIC"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(12, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>SCROLL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCROLL_VALUE
	 * @generated
	 * @ordered
	 */
	SCROLL(13, "SCROLL", "SCROLL"),

	/**
	 * The '<em><b>WELDEDSHELLHERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WELDEDSHELLHERMETIC_VALUE
	 * @generated
	 * @ordered
	 */
	WELDEDSHELLHERMETIC(14, "WELDEDSHELLHERMETIC", "WELDEDSHELLHERMETIC"),

	/**
	 * The '<em><b>BOOSTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOSTER_VALUE
	 * @generated
	 * @ordered
	 */
	BOOSTER(15, "BOOSTER", "BOOSTER"),

	/**
	 * The '<em><b>ROLLINGPISTON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGPISTON_VALUE
	 * @generated
	 * @ordered
	 */
	ROLLINGPISTON(16, "ROLLINGPISTON", "ROLLINGPISTON"),

	/**
	 * The '<em><b>ROTARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARY_VALUE
	 * @generated
	 * @ordered
	 */
	ROTARY(17, "ROTARY", "ROTARY");

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
	 * The '<em><b>TWINSCREW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWINSCREW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWINSCREW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWINSCREW_VALUE = 1;

	/**
	 * The '<em><b>SINGLESCREW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLESCREW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLESCREW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLESCREW_VALUE = 2;

	/**
	 * The '<em><b>SINGLESTAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLESTAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLESTAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLESTAGE_VALUE = 3;

	/**
	 * The '<em><b>RECIPROCATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECIPROCATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECIPROCATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECIPROCATING_VALUE = 4;

	/**
	 * The '<em><b>TROCHOIDAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TROCHOIDAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TROCHOIDAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TROCHOIDAL_VALUE = 5;

	/**
	 * The '<em><b>OPENTYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPENTYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPENTYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPENTYPE_VALUE = 6;

	/**
	 * The '<em><b>ROTARYVANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARYVANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARYVANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARYVANE_VALUE = 7;

	/**
	 * The '<em><b>SEMIHERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEMIHERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEMIHERMETIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEMIHERMETIC_VALUE = 8;

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
	public static final int USERDEFINED_VALUE = 9;

	/**
	 * The '<em><b>HERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HERMETIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HERMETIC_VALUE = 10;

	/**
	 * The '<em><b>DYNAMIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DYNAMIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC_VALUE = 11;

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
	public static final int NOTDEFINED_VALUE = 12;

	/**
	 * The '<em><b>SCROLL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCROLL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCROLL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCROLL_VALUE = 13;

	/**
	 * The '<em><b>WELDEDSHELLHERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WELDEDSHELLHERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WELDEDSHELLHERMETIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WELDEDSHELLHERMETIC_VALUE = 14;

	/**
	 * The '<em><b>BOOSTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOSTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOSTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOSTER_VALUE = 15;

	/**
	 * The '<em><b>ROLLINGPISTON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLINGPISTON</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLINGPISTON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLINGPISTON_VALUE = 16;

	/**
	 * The '<em><b>ROTARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARY_VALUE = 17;

	/**
	 * An array of all the '<em><b>Ifc Compressor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCompressorTypeEnum[] VALUES_ARRAY = new IfcCompressorTypeEnum[] { NULL, TWINSCREW, SINGLESCREW, SINGLESTAGE, RECIPROCATING, TROCHOIDAL, OPENTYPE, ROTARYVANE, SEMIHERMETIC, USERDEFINED, HERMETIC, DYNAMIC,
			NOTDEFINED, SCROLL, WELDEDSHELLHERMETIC, BOOSTER, ROLLINGPISTON, ROTARY, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Compressor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCompressorTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Compressor Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCompressorTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCompressorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Compressor Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCompressorTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCompressorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Compressor Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCompressorTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case TWINSCREW_VALUE:
			return TWINSCREW;
		case SINGLESCREW_VALUE:
			return SINGLESCREW;
		case SINGLESTAGE_VALUE:
			return SINGLESTAGE;
		case RECIPROCATING_VALUE:
			return RECIPROCATING;
		case TROCHOIDAL_VALUE:
			return TROCHOIDAL;
		case OPENTYPE_VALUE:
			return OPENTYPE;
		case ROTARYVANE_VALUE:
			return ROTARYVANE;
		case SEMIHERMETIC_VALUE:
			return SEMIHERMETIC;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case HERMETIC_VALUE:
			return HERMETIC;
		case DYNAMIC_VALUE:
			return DYNAMIC;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case SCROLL_VALUE:
			return SCROLL;
		case WELDEDSHELLHERMETIC_VALUE:
			return WELDEDSHELLHERMETIC;
		case BOOSTER_VALUE:
			return BOOSTER;
		case ROLLINGPISTON_VALUE:
			return ROLLINGPISTON;
		case ROTARY_VALUE:
			return ROTARY;
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
	private IfcCompressorTypeEnum(int value, String name, String literal) {
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

} //IfcCompressorTypeEnum
