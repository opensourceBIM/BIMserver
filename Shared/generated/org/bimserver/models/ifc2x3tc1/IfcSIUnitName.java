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
	 * The '<em><b>TESLA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESLA_VALUE
	 * @generated
	 * @ordered
	 */
	TESLA(1, "TESLA", "TESLA"),

	/**
	 * The '<em><b>HENRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HENRY_VALUE
	 * @generated
	 * @ordered
	 */
	HENRY(2, "HENRY", "HENRY"),

	/**
	 * The '<em><b>METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRE_VALUE
	 * @generated
	 * @ordered
	 */
	METRE(3, "METRE", "METRE"),

	/**
	 * The '<em><b>SECOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND(4, "SECOND", "SECOND"),

	/**
	 * The '<em><b>AMPERE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMPERE_VALUE
	 * @generated
	 * @ordered
	 */
	AMPERE(5, "AMPERE", "AMPERE"),

	/**
	 * The '<em><b>JOULE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOULE_VALUE
	 * @generated
	 * @ordered
	 */
	JOULE(6, "JOULE", "JOULE"),

	/**
	 * The '<em><b>GRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAM_VALUE
	 * @generated
	 * @ordered
	 */
	GRAM(7, "GRAM", "GRAM"), /**
								 * The '<em><b>KELVIN</b></em>' literal object.
								 * <!-- begin-user-doc -->
								 * <!-- end-user-doc -->
								 * @see #KELVIN_VALUE
								 * @generated
								 * @ordered
								 */
	KELVIN(8, "KELVIN", "KELVIN"),

	/**
	 * The '<em><b>LUMEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMEN_VALUE
	 * @generated
	 * @ordered
	 */
	LUMEN(9, "LUMEN", "LUMEN"),

	/**
	 * The '<em><b>FARAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FARAD_VALUE
	 * @generated
	 * @ordered
	 */
	FARAD(10, "FARAD", "FARAD"),

	/**
	 * The '<em><b>STERADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STERADIAN_VALUE
	 * @generated
	 * @ordered
	 */
	STERADIAN(11, "STERADIAN", "STERADIAN"),

	/**
	 * The '<em><b>LUX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUX_VALUE
	 * @generated
	 * @ordered
	 */
	LUX(12, "LUX", "LUX"),

	/**
	 * The '<em><b>DEGREE CELSIUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEGREE_CELSIUS_VALUE
	 * @generated
	 * @ordered
	 */
	DEGREE_CELSIUS(13, "DEGREE_CELSIUS", "DEGREE_CELSIUS"),

	/**
	 * The '<em><b>SIEVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEVERT_VALUE
	 * @generated
	 * @ordered
	 */
	SIEVERT(14, "SIEVERT", "SIEVERT"),

	/**
	 * The '<em><b>CUBIC METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUBIC_METRE_VALUE
	 * @generated
	 * @ordered
	 */
	CUBIC_METRE(15, "CUBIC_METRE", "CUBIC_METRE"),

	/**
	 * The '<em><b>NEWTON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWTON_VALUE
	 * @generated
	 * @ordered
	 */
	NEWTON(16, "NEWTON", "NEWTON"),

	/**
	 * The '<em><b>WATT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATT_VALUE
	 * @generated
	 * @ordered
	 */
	WATT(17, "WATT", "WATT"),

	/**
	 * The '<em><b>CANDELA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANDELA_VALUE
	 * @generated
	 * @ordered
	 */
	CANDELA(18, "CANDELA", "CANDELA"),

	/**
	 * The '<em><b>RADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIAN_VALUE
	 * @generated
	 * @ordered
	 */
	RADIAN(19, "RADIAN", "RADIAN"),

	/**
	 * The '<em><b>PASCAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASCAL_VALUE
	 * @generated
	 * @ordered
	 */
	PASCAL(20, "PASCAL", "PASCAL"),

	/**
	 * The '<em><b>VOLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLT_VALUE
	 * @generated
	 * @ordered
	 */
	VOLT(21, "VOLT", "VOLT"),

	/**
	 * The '<em><b>WEBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEBER_VALUE
	 * @generated
	 * @ordered
	 */
	WEBER(22, "WEBER", "WEBER"),

	/**
	 * The '<em><b>COULOMB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COULOMB_VALUE
	 * @generated
	 * @ordered
	 */
	COULOMB(23, "COULOMB", "COULOMB"),

	/**
	 * The '<em><b>SQUARE METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQUARE_METRE_VALUE
	 * @generated
	 * @ordered
	 */
	SQUARE_METRE(24, "SQUARE_METRE", "SQUARE_METRE"),

	/**
	 * The '<em><b>HERTZ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERTZ_VALUE
	 * @generated
	 * @ordered
	 */
	HERTZ(25, "HERTZ", "HERTZ"),

	/**
	 * The '<em><b>SIEMENS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEMENS_VALUE
	 * @generated
	 * @ordered
	 */
	SIEMENS(26, "SIEMENS", "SIEMENS"),

	/**
	 * The '<em><b>BECQUEREL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BECQUEREL_VALUE
	 * @generated
	 * @ordered
	 */
	BECQUEREL(27, "BECQUEREL", "BECQUEREL"),

	/**
	 * The '<em><b>MOLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLE_VALUE
	 * @generated
	 * @ordered
	 */
	MOLE(28, "MOLE", "MOLE"),

	/**
	 * The '<em><b>OHM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OHM_VALUE
	 * @generated
	 * @ordered
	 */
	OHM(29, "OHM", "OHM"),

	/**
	 * The '<em><b>GRAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAY_VALUE
	 * @generated
	 * @ordered
	 */
	GRAY(30, "GRAY", "GRAY");

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
	public static final int TESLA_VALUE = 1;

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
	public static final int HENRY_VALUE = 2;

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
	public static final int METRE_VALUE = 3;

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
	public static final int SECOND_VALUE = 4;

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
	public static final int AMPERE_VALUE = 5;

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
	public static final int JOULE_VALUE = 6;

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
	public static final int GRAM_VALUE = 7;

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
	public static final int KELVIN_VALUE = 8;

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
	public static final int LUMEN_VALUE = 9;

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
	public static final int FARAD_VALUE = 10;

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
	public static final int STERADIAN_VALUE = 11;

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
	public static final int LUX_VALUE = 12;

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
	public static final int DEGREE_CELSIUS_VALUE = 13;

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
	public static final int SIEVERT_VALUE = 14;

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
	public static final int CUBIC_METRE_VALUE = 15;

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
	public static final int NEWTON_VALUE = 16;

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
	public static final int WATT_VALUE = 17;

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
	public static final int CANDELA_VALUE = 18;

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
	public static final int RADIAN_VALUE = 19;

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
	public static final int PASCAL_VALUE = 20;

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
	public static final int VOLT_VALUE = 21;

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
	public static final int WEBER_VALUE = 22;

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
	public static final int COULOMB_VALUE = 23;

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
	public static final int SQUARE_METRE_VALUE = 24;

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
	public static final int HERTZ_VALUE = 25;

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
	public static final int SIEMENS_VALUE = 26;

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
	public static final int BECQUEREL_VALUE = 27;

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
	public static final int MOLE_VALUE = 28;

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
	public static final int OHM_VALUE = 29;

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
	public static final int GRAY_VALUE = 30;

	/**
	 * An array of all the '<em><b>Ifc SI Unit Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSIUnitName[] VALUES_ARRAY = new IfcSIUnitName[] { NULL, TESLA, HENRY, METRE, SECOND, AMPERE, JOULE, GRAM, KELVIN, LUMEN, FARAD, STERADIAN, LUX,
			DEGREE_CELSIUS, SIEVERT, CUBIC_METRE, NEWTON, WATT, CANDELA, RADIAN, PASCAL, VOLT, WEBER, COULOMB, SQUARE_METRE, HERTZ, SIEMENS, BECQUEREL, MOLE, OHM, GRAY, };

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
	 * @generated
	 */
	public static IfcSIUnitName get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case TESLA_VALUE:
			return TESLA;
		case HENRY_VALUE:
			return HENRY;
		case METRE_VALUE:
			return METRE;
		case SECOND_VALUE:
			return SECOND;
		case AMPERE_VALUE:
			return AMPERE;
		case JOULE_VALUE:
			return JOULE;
		case GRAM_VALUE:
			return GRAM;
		case KELVIN_VALUE:
			return KELVIN;
		case LUMEN_VALUE:
			return LUMEN;
		case FARAD_VALUE:
			return FARAD;
		case STERADIAN_VALUE:
			return STERADIAN;
		case LUX_VALUE:
			return LUX;
		case DEGREE_CELSIUS_VALUE:
			return DEGREE_CELSIUS;
		case SIEVERT_VALUE:
			return SIEVERT;
		case CUBIC_METRE_VALUE:
			return CUBIC_METRE;
		case NEWTON_VALUE:
			return NEWTON;
		case WATT_VALUE:
			return WATT;
		case CANDELA_VALUE:
			return CANDELA;
		case RADIAN_VALUE:
			return RADIAN;
		case PASCAL_VALUE:
			return PASCAL;
		case VOLT_VALUE:
			return VOLT;
		case WEBER_VALUE:
			return WEBER;
		case COULOMB_VALUE:
			return COULOMB;
		case SQUARE_METRE_VALUE:
			return SQUARE_METRE;
		case HERTZ_VALUE:
			return HERTZ;
		case SIEMENS_VALUE:
			return SIEMENS;
		case BECQUEREL_VALUE:
			return BECQUEREL;
		case MOLE_VALUE:
			return MOLE;
		case OHM_VALUE:
			return OHM;
		case GRAY_VALUE:
			return GRAY;
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
