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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the literals of the enumeration '<em><b>Ifc SI Unit Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSIUnitName()
 * @model
 * @generated
 */
public enum IfcSIUnitName implements Enumerator {
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
	 * The '<em><b>RADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIAN_VALUE
	 * @generated
	 * @ordered
	 */
	RADIAN(1, "RADIAN", "RADIAN"),

	/**
	 * The '<em><b>GRAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAY_VALUE
	 * @generated
	 * @ordered
	 */
	GRAY(2, "GRAY", "GRAY"),

	/**
	 * The '<em><b>BECQUEREL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BECQUEREL_VALUE
	 * @generated
	 * @ordered
	 */
	BECQUEREL(3, "BECQUEREL", "BECQUEREL"),

	/**
	 * The '<em><b>DEGREE CELSIUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEGREE_CELSIUS_VALUE
	 * @generated
	 * @ordered
	 */
	DEGREE_CELSIUS(4, "DEGREE_CELSIUS", "DEGREE_CELSIUS"),

	/**
	 * The '<em><b>CUBIC METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUBIC_METRE_VALUE
	 * @generated
	 * @ordered
	 */
	CUBIC_METRE(5, "CUBIC_METRE", "CUBIC_METRE"),

	/**
	 * The '<em><b>SIEVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEVERT_VALUE
	 * @generated
	 * @ordered
	 */
	SIEVERT(6, "SIEVERT", "SIEVERT"),

	/**
	 * The '<em><b>WEBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEBER_VALUE
	 * @generated
	 * @ordered
	 */
	WEBER(7, "WEBER", "WEBER"),

	/**
	 * The '<em><b>PASCAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASCAL_VALUE
	 * @generated
	 * @ordered
	 */
	PASCAL(8, "PASCAL", "PASCAL"),

	/**
	 * The '<em><b>OHM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OHM_VALUE
	 * @generated
	 * @ordered
	 */
	OHM(9, "OHM", "OHM"),

	/**
	 * The '<em><b>AMPERE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMPERE_VALUE
	 * @generated
	 * @ordered
	 */
	AMPERE(10, "AMPERE", "AMPERE"),

	/**
	 * The '<em><b>LUMEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMEN_VALUE
	 * @generated
	 * @ordered
	 */
	LUMEN(11, "LUMEN", "LUMEN"),

	/**
	 * The '<em><b>JOULE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOULE_VALUE
	 * @generated
	 * @ordered
	 */
	JOULE(12, "JOULE", "JOULE"),

	/**
	 * The '<em><b>COULOMB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COULOMB_VALUE
	 * @generated
	 * @ordered
	 */
	COULOMB(13, "COULOMB", "COULOMB"),

	/**
	 * The '<em><b>KELVIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KELVIN_VALUE
	 * @generated
	 * @ordered
	 */
	KELVIN(14, "KELVIN", "KELVIN"),

	/**
	 * The '<em><b>WATT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATT_VALUE
	 * @generated
	 * @ordered
	 */
	WATT(15, "WATT", "WATT"),

	/**
	 * The '<em><b>FARAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FARAD_VALUE
	 * @generated
	 * @ordered
	 */
	FARAD(16, "FARAD", "FARAD"),

	/**
	 * The '<em><b>STERADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STERADIAN_VALUE
	 * @generated
	 * @ordered
	 */
	STERADIAN(17, "STERADIAN", "STERADIAN"),

	/**
	 * The '<em><b>VOLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLT_VALUE
	 * @generated
	 * @ordered
	 */
	VOLT(18, "VOLT", "VOLT"),

	/**
	 * The '<em><b>SIEMENS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEMENS_VALUE
	 * @generated
	 * @ordered
	 */
	SIEMENS(19, "SIEMENS", "SIEMENS"),

	/**
	 * The '<em><b>HERTZ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERTZ_VALUE
	 * @generated
	 * @ordered
	 */
	HERTZ(20, "HERTZ", "HERTZ"),

	/**
	 * The '<em><b>SQUARE METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQUARE_METRE_VALUE
	 * @generated
	 * @ordered
	 */
	SQUARE_METRE(21, "SQUARE_METRE", "SQUARE_METRE"),

	/**
	 * The '<em><b>LUX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUX_VALUE
	 * @generated
	 * @ordered
	 */
	LUX(22, "LUX", "LUX"),

	/**
	 * The '<em><b>HENRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HENRY_VALUE
	 * @generated
	 * @ordered
	 */
	HENRY(23, "HENRY", "HENRY"),

	/**
	 * The '<em><b>CANDELA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANDELA_VALUE
	 * @generated
	 * @ordered
	 */
	CANDELA(24, "CANDELA", "CANDELA"),

	/**
	 * The '<em><b>METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRE_VALUE
	 * @generated
	 * @ordered
	 */
	METRE(25, "METRE", "METRE"),

	/**
	 * The '<em><b>GRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAM_VALUE
	 * @generated
	 * @ordered
	 */
	GRAM(26, "GRAM", "GRAM"),

	/**
	 * The '<em><b>TESLA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESLA_VALUE
	 * @generated
	 * @ordered
	 */
	TESLA(27, "TESLA", "TESLA"),

	/**
	 * The '<em><b>SECOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND(28, "SECOND", "SECOND"),

	/**
	 * The '<em><b>NEWTON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWTON_VALUE
	 * @generated
	 * @ordered
	 */
	NEWTON(29, "NEWTON", "NEWTON"),

	/**
	 * The '<em><b>MOLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLE_VALUE
	 * @generated
	 * @ordered
	 */
	MOLE(30, "MOLE", "MOLE");

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
	 * The '<em><b>RADIAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIAN_VALUE = 1;

	/**
	 * The '<em><b>GRAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAY_VALUE = 2;

	/**
	 * The '<em><b>BECQUEREL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BECQUEREL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BECQUEREL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BECQUEREL_VALUE = 3;

	/**
	 * The '<em><b>DEGREE CELSIUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEGREE CELSIUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEGREE_CELSIUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEGREE_CELSIUS_VALUE = 4;

	/**
	 * The '<em><b>CUBIC METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUBIC METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUBIC_METRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUBIC_METRE_VALUE = 5;

	/**
	 * The '<em><b>SIEVERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIEVERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIEVERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIEVERT_VALUE = 6;

	/**
	 * The '<em><b>WEBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WEBER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEBER_VALUE = 7;

	/**
	 * The '<em><b>PASCAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PASCAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASCAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASCAL_VALUE = 8;

	/**
	 * The '<em><b>OHM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OHM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OHM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OHM_VALUE = 9;

	/**
	 * The '<em><b>AMPERE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AMPERE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMPERE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AMPERE_VALUE = 10;

	/**
	 * The '<em><b>LUMEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMEN_VALUE = 11;

	/**
	 * The '<em><b>JOULE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOULE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOULE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOULE_VALUE = 12;

	/**
	 * The '<em><b>COULOMB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COULOMB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COULOMB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COULOMB_VALUE = 13;

	/**
	 * The '<em><b>KELVIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KELVIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KELVIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KELVIN_VALUE = 14;

	/**
	 * The '<em><b>WATT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATT_VALUE = 15;

	/**
	 * The '<em><b>FARAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FARAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FARAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FARAD_VALUE = 16;

	/**
	 * The '<em><b>STERADIAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STERADIAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STERADIAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STERADIAN_VALUE = 17;

	/**
	 * The '<em><b>VOLT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VOLT_VALUE = 18;

	/**
	 * The '<em><b>SIEMENS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIEMENS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIEMENS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIEMENS_VALUE = 19;

	/**
	 * The '<em><b>HERTZ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HERTZ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HERTZ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HERTZ_VALUE = 20;

	/**
	 * The '<em><b>SQUARE METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SQUARE METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SQUARE_METRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SQUARE_METRE_VALUE = 21;

	/**
	 * The '<em><b>LUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUX_VALUE = 22;

	/**
	 * The '<em><b>HENRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HENRY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HENRY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HENRY_VALUE = 23;

	/**
	 * The '<em><b>CANDELA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CANDELA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANDELA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CANDELA_VALUE = 24;

	/**
	 * The '<em><b>METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int METRE_VALUE = 25;

	/**
	 * The '<em><b>GRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAM_VALUE = 26;

	/**
	 * The '<em><b>TESLA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TESLA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TESLA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESLA_VALUE = 27;

	/**
	 * The '<em><b>SECOND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECOND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_VALUE = 28;

	/**
	 * The '<em><b>NEWTON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEWTON</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEWTON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEWTON_VALUE = 29;

	/**
	 * The '<em><b>MOLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOLE_VALUE = 30;

	/**
	 * An array of all the '<em><b>Ifc SI Unit Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSIUnitName[] VALUES_ARRAY = new IfcSIUnitName[] { NULL, RADIAN, GRAY, BECQUEREL,
			DEGREE_CELSIUS, CUBIC_METRE, SIEVERT, WEBER, PASCAL, OHM, AMPERE, LUMEN, JOULE, COULOMB, KELVIN, WATT,
			FARAD, STERADIAN, VOLT, SIEMENS, HERTZ, SQUARE_METRE, LUX, HENRY, CANDELA, METRE, GRAM, TESLA, SECOND,
			NEWTON, MOLE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc SI Unit Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSIUnitName> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc SI Unit Name</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIUnitName get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSIUnitName result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Unit Name</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIUnitName getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSIUnitName result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Unit Name</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIUnitName get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case RADIAN_VALUE:
			return RADIAN;
		case GRAY_VALUE:
			return GRAY;
		case BECQUEREL_VALUE:
			return BECQUEREL;
		case DEGREE_CELSIUS_VALUE:
			return DEGREE_CELSIUS;
		case CUBIC_METRE_VALUE:
			return CUBIC_METRE;
		case SIEVERT_VALUE:
			return SIEVERT;
		case WEBER_VALUE:
			return WEBER;
		case PASCAL_VALUE:
			return PASCAL;
		case OHM_VALUE:
			return OHM;
		case AMPERE_VALUE:
			return AMPERE;
		case LUMEN_VALUE:
			return LUMEN;
		case JOULE_VALUE:
			return JOULE;
		case COULOMB_VALUE:
			return COULOMB;
		case KELVIN_VALUE:
			return KELVIN;
		case WATT_VALUE:
			return WATT;
		case FARAD_VALUE:
			return FARAD;
		case STERADIAN_VALUE:
			return STERADIAN;
		case VOLT_VALUE:
			return VOLT;
		case SIEMENS_VALUE:
			return SIEMENS;
		case HERTZ_VALUE:
			return HERTZ;
		case SQUARE_METRE_VALUE:
			return SQUARE_METRE;
		case LUX_VALUE:
			return LUX;
		case HENRY_VALUE:
			return HENRY;
		case CANDELA_VALUE:
			return CANDELA;
		case METRE_VALUE:
			return METRE;
		case GRAM_VALUE:
			return GRAM;
		case TESLA_VALUE:
			return TESLA;
		case SECOND_VALUE:
			return SECOND;
		case NEWTON_VALUE:
			return NEWTON;
		case MOLE_VALUE:
			return MOLE;
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
	private IfcSIUnitName(int value, String name, String literal) {
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

} //IfcSIUnitName
