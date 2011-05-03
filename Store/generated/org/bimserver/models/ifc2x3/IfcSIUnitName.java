/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc SI Unit Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSIUnitName()
 * @model
 * @generated
 */
public enum IfcSIUnitName implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>TESLA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESLA
	 * @generated
	 * @ordered
	 */
	TESLA_LITERAL(1, "TESLA", "TESLA"),

	/**
	 * The '<em><b>HENRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HENRY
	 * @generated
	 * @ordered
	 */
	HENRY_LITERAL(2, "HENRY", "HENRY"),

	/**
	 * The '<em><b>METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRE
	 * @generated
	 * @ordered
	 */
	METRE_LITERAL(3, "METRE", "METRE"),

	/**
	 * The '<em><b>SECOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND
	 * @generated
	 * @ordered
	 */
	SECOND_LITERAL(4, "SECOND", "SECOND"),

	/**
	 * The '<em><b>AMPERE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMPERE
	 * @generated
	 * @ordered
	 */
	AMPERE_LITERAL(5, "AMPERE", "AMPERE"),

	/**
	 * The '<em><b>JOULE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOULE
	 * @generated
	 * @ordered
	 */
	JOULE_LITERAL(6, "JOULE", "JOULE"),

	/**
	 * The '<em><b>KELVIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KELVIN
	 * @generated
	 * @ordered
	 */
	KELVIN_LITERAL(7, "KELVIN", "KELVIN"),

	/**
	 * The '<em><b>GRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAM
	 * @generated
	 * @ordered
	 */
	GRAM_LITERAL(8, "GRAM", "GRAM"),

	/**
	 * The '<em><b>LUMEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMEN
	 * @generated
	 * @ordered
	 */
	LUMEN_LITERAL(9, "LUMEN", "LUMEN"),

	/**
	 * The '<em><b>FARAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FARAD
	 * @generated
	 * @ordered
	 */
	FARAD_LITERAL(10, "FARAD", "FARAD"),

	/**
	 * The '<em><b>STERADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STERADIAN
	 * @generated
	 * @ordered
	 */
	STERADIAN_LITERAL(11, "STERADIAN", "STERADIAN"),

	/**
	 * The '<em><b>LUX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUX
	 * @generated
	 * @ordered
	 */
	LUX_LITERAL(12, "LUX", "LUX"),

	/**
	 * The '<em><b>DEGREE CELSIUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEGREE_CELSIUS
	 * @generated
	 * @ordered
	 */
	DEGREE_CELSIUS_LITERAL(13, "DEGREE_CELSIUS", "DEGREE_CELSIUS"),

	/**
	 * The '<em><b>SIEVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEVERT
	 * @generated
	 * @ordered
	 */
	SIEVERT_LITERAL(14, "SIEVERT", "SIEVERT"),

	/**
	 * The '<em><b>CUBIC METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUBIC_METRE
	 * @generated
	 * @ordered
	 */
	CUBIC_METRE_LITERAL(15, "CUBIC_METRE", "CUBIC_METRE"),

	/**
	 * The '<em><b>NEWTON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWTON
	 * @generated
	 * @ordered
	 */
	NEWTON_LITERAL(16, "NEWTON", "NEWTON"),

	/**
	 * The '<em><b>WATT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATT
	 * @generated
	 * @ordered
	 */
	WATT_LITERAL(17, "WATT", "WATT"),

	/**
	 * The '<em><b>CANDELA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANDELA
	 * @generated
	 * @ordered
	 */
	CANDELA_LITERAL(18, "CANDELA", "CANDELA"),

	/**
	 * The '<em><b>RADIAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIAN
	 * @generated
	 * @ordered
	 */
	RADIAN_LITERAL(19, "RADIAN", "RADIAN"),

	/**
	 * The '<em><b>PASCAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASCAL
	 * @generated
	 * @ordered
	 */
	PASCAL_LITERAL(20, "PASCAL", "PASCAL"),

	/**
	 * The '<em><b>VOLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLT
	 * @generated
	 * @ordered
	 */
	VOLT_LITERAL(21, "VOLT", "VOLT"),

	/**
	 * The '<em><b>WEBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEBER
	 * @generated
	 * @ordered
	 */
	WEBER_LITERAL(22, "WEBER", "WEBER"),

	/**
	 * The '<em><b>COULOMB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COULOMB
	 * @generated
	 * @ordered
	 */
	COULOMB_LITERAL(23, "COULOMB", "COULOMB"),

	/**
	 * The '<em><b>SQUARE METRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQUARE_METRE
	 * @generated
	 * @ordered
	 */
	SQUARE_METRE_LITERAL(24, "SQUARE_METRE", "SQUARE_METRE"),

	/**
	 * The '<em><b>HERTZ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERTZ
	 * @generated
	 * @ordered
	 */
	HERTZ_LITERAL(25, "HERTZ", "HERTZ"),

	/**
	 * The '<em><b>SIEMENS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIEMENS
	 * @generated
	 * @ordered
	 */
	SIEMENS_LITERAL(26, "SIEMENS", "SIEMENS"),

	/**
	 * The '<em><b>BECQUEREL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BECQUEREL
	 * @generated
	 * @ordered
	 */
	BECQUEREL_LITERAL(27, "BECQUEREL", "BECQUEREL"),

	/**
	 * The '<em><b>MOLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLE
	 * @generated
	 * @ordered
	 */
	MOLE_LITERAL(28, "MOLE", "MOLE"),

	/**
	 * The '<em><b>OHM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OHM
	 * @generated
	 * @ordered
	 */
	OHM_LITERAL(29, "OHM", "OHM"),

	/**
	 * The '<em><b>GRAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAY
	 * @generated
	 * @ordered
	 */
	GRAY_LITERAL(30, "GRAY", "GRAY");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>TESLA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TESLA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TESLA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESLA = 1;

	/**
	 * The '<em><b>HENRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HENRY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HENRY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HENRY = 2;

	/**
	 * The '<em><b>METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int METRE = 3;

	/**
	 * The '<em><b>SECOND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECOND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECOND = 4;

	/**
	 * The '<em><b>AMPERE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AMPERE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMPERE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AMPERE = 5;

	/**
	 * The '<em><b>JOULE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOULE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOULE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOULE = 6;

	/**
	 * The '<em><b>KELVIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KELVIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KELVIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KELVIN = 7;

	/**
	 * The '<em><b>GRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAM = 8;

	/**
	 * The '<em><b>LUMEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMEN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMEN = 9;

	/**
	 * The '<em><b>FARAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FARAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FARAD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FARAD = 10;

	/**
	 * The '<em><b>STERADIAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STERADIAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STERADIAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STERADIAN = 11;

	/**
	 * The '<em><b>LUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUX = 12;

	/**
	 * The '<em><b>DEGREE CELSIUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEGREE CELSIUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEGREE_CELSIUS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEGREE_CELSIUS = 13;

	/**
	 * The '<em><b>SIEVERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIEVERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIEVERT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIEVERT = 14;

	/**
	 * The '<em><b>CUBIC METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUBIC METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUBIC_METRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUBIC_METRE = 15;

	/**
	 * The '<em><b>NEWTON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEWTON</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEWTON_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEWTON = 16;

	/**
	 * The '<em><b>WATT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATT = 17;

	/**
	 * The '<em><b>CANDELA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CANDELA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANDELA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CANDELA = 18;

	/**
	 * The '<em><b>RADIAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIAN = 19;

	/**
	 * The '<em><b>PASCAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PASCAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASCAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASCAL = 20;

	/**
	 * The '<em><b>VOLT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VOLT = 21;

	/**
	 * The '<em><b>WEBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WEBER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEBER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEBER = 22;

	/**
	 * The '<em><b>COULOMB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COULOMB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COULOMB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COULOMB = 23;

	/**
	 * The '<em><b>SQUARE METRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SQUARE METRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SQUARE_METRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SQUARE_METRE = 24;

	/**
	 * The '<em><b>HERTZ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HERTZ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HERTZ_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HERTZ = 25;

	/**
	 * The '<em><b>SIEMENS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIEMENS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIEMENS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIEMENS = 26;

	/**
	 * The '<em><b>BECQUEREL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BECQUEREL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BECQUEREL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BECQUEREL = 27;

	/**
	 * The '<em><b>MOLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOLE = 28;

	/**
	 * The '<em><b>OHM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OHM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OHM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OHM = 29;

	/**
	 * The '<em><b>GRAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAY = 30;

	/**
	 * An array of all the '<em><b>Ifc SI Unit Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSIUnitName[] VALUES_ARRAY =
		new IfcSIUnitName[]
		{
			NULL_LITERAL,
			TESLA_LITERAL,
			HENRY_LITERAL,
			METRE_LITERAL,
			SECOND_LITERAL,
			AMPERE_LITERAL,
			JOULE_LITERAL,
			KELVIN_LITERAL,
			GRAM_LITERAL,
			LUMEN_LITERAL,
			FARAD_LITERAL,
			STERADIAN_LITERAL,
			LUX_LITERAL,
			DEGREE_CELSIUS_LITERAL,
			SIEVERT_LITERAL,
			CUBIC_METRE_LITERAL,
			NEWTON_LITERAL,
			WATT_LITERAL,
			CANDELA_LITERAL,
			RADIAN_LITERAL,
			PASCAL_LITERAL,
			VOLT_LITERAL,
			WEBER_LITERAL,
			COULOMB_LITERAL,
			SQUARE_METRE_LITERAL,
			HERTZ_LITERAL,
			SIEMENS_LITERAL,
			BECQUEREL_LITERAL,
			MOLE_LITERAL,
			OHM_LITERAL,
			GRAY_LITERAL,
		};

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
	public static IfcSIUnitName get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSIUnitName result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
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
	public static IfcSIUnitName getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSIUnitName result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
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
	public static IfcSIUnitName get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case TESLA: return TESLA_LITERAL;
			case HENRY: return HENRY_LITERAL;
			case METRE: return METRE_LITERAL;
			case SECOND: return SECOND_LITERAL;
			case AMPERE: return AMPERE_LITERAL;
			case JOULE: return JOULE_LITERAL;
			case KELVIN: return KELVIN_LITERAL;
			case GRAM: return GRAM_LITERAL;
			case LUMEN: return LUMEN_LITERAL;
			case FARAD: return FARAD_LITERAL;
			case STERADIAN: return STERADIAN_LITERAL;
			case LUX: return LUX_LITERAL;
			case DEGREE_CELSIUS: return DEGREE_CELSIUS_LITERAL;
			case SIEVERT: return SIEVERT_LITERAL;
			case CUBIC_METRE: return CUBIC_METRE_LITERAL;
			case NEWTON: return NEWTON_LITERAL;
			case WATT: return WATT_LITERAL;
			case CANDELA: return CANDELA_LITERAL;
			case RADIAN: return RADIAN_LITERAL;
			case PASCAL: return PASCAL_LITERAL;
			case VOLT: return VOLT_LITERAL;
			case WEBER: return WEBER_LITERAL;
			case COULOMB: return COULOMB_LITERAL;
			case SQUARE_METRE: return SQUARE_METRE_LITERAL;
			case HERTZ: return HERTZ_LITERAL;
			case SIEMENS: return SIEMENS_LITERAL;
			case BECQUEREL: return BECQUEREL_LITERAL;
			case MOLE: return MOLE_LITERAL;
			case OHM: return OHM_LITERAL;
			case GRAY: return GRAY_LITERAL;
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
	private IfcSIUnitName(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //IfcSIUnitName
