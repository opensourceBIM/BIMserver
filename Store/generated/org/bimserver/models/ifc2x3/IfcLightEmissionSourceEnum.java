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
 * A representation of the literals of the enumeration '<em><b>Ifc Light Emission Source Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightEmissionSourceEnum()
 * @model
 * @generated
 */
public enum IfcLightEmissionSourceEnum implements Enumerator
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
	 * The '<em><b>LOWVOLTAGEHALOGEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWVOLTAGEHALOGEN
	 * @generated
	 * @ordered
	 */
	LOWVOLTAGEHALOGEN_LITERAL(1, "LOWVOLTAGEHALOGEN", "LOWVOLTAGEHALOGEN"),

	/**
	 * The '<em><b>MAINVOLTAGEHALOGEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAINVOLTAGEHALOGEN
	 * @generated
	 * @ordered
	 */
	MAINVOLTAGEHALOGEN_LITERAL(2, "MAINVOLTAGEHALOGEN", "MAINVOLTAGEHALOGEN"),

	/**
	 * The '<em><b>HIGHPRESSUREMERCURY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHPRESSUREMERCURY
	 * @generated
	 * @ordered
	 */
	HIGHPRESSUREMERCURY_LITERAL(3, "HIGHPRESSUREMERCURY", "HIGHPRESSUREMERCURY"),

	/**
	 * The '<em><b>COMPACTFLUORESCENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPACTFLUORESCENT
	 * @generated
	 * @ordered
	 */
	COMPACTFLUORESCENT_LITERAL(4, "COMPACTFLUORESCENT", "COMPACTFLUORESCENT"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(5, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>TUNGSTENFILAMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUNGSTENFILAMENT
	 * @generated
	 * @ordered
	 */
	TUNGSTENFILAMENT_LITERAL(6, "TUNGSTENFILAMENT", "TUNGSTENFILAMENT"),

	/**
	 * The '<em><b>METALHALIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METALHALIDE
	 * @generated
	 * @ordered
	 */
	METALHALIDE_LITERAL(7, "METALHALIDE", "METALHALIDE"),

	/**
	 * The '<em><b>LOWPRESSURESODIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWPRESSURESODIUM
	 * @generated
	 * @ordered
	 */
	LOWPRESSURESODIUM_LITERAL(8, "LOWPRESSURESODIUM", "LOWPRESSURESODIUM"),

	/**
	 * The '<em><b>HIGHPRESSURESODIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHPRESSURESODIUM
	 * @generated
	 * @ordered
	 */
	HIGHPRESSURESODIUM_LITERAL(9, "HIGHPRESSURESODIUM", "HIGHPRESSURESODIUM"),

	/**
	 * The '<em><b>LIGHTEMITTINGDIODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTEMITTINGDIODE
	 * @generated
	 * @ordered
	 */
	LIGHTEMITTINGDIODE_LITERAL(10, "LIGHTEMITTINGDIODE", "LIGHTEMITTINGDIODE"),

	/**
	 * The '<em><b>FLUORESCENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLUORESCENT
	 * @generated
	 * @ordered
	 */
	FLUORESCENT_LITERAL(11, "FLUORESCENT", "FLUORESCENT");

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
	 * The '<em><b>LOWVOLTAGEHALOGEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWVOLTAGEHALOGEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWVOLTAGEHALOGEN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWVOLTAGEHALOGEN = 1;

	/**
	 * The '<em><b>MAINVOLTAGEHALOGEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAINVOLTAGEHALOGEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAINVOLTAGEHALOGEN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAINVOLTAGEHALOGEN = 2;

	/**
	 * The '<em><b>HIGHPRESSUREMERCURY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIGHPRESSUREMERCURY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGHPRESSUREMERCURY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGHPRESSUREMERCURY = 3;

	/**
	 * The '<em><b>COMPACTFLUORESCENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPACTFLUORESCENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPACTFLUORESCENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPACTFLUORESCENT = 4;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED = 5;

	/**
	 * The '<em><b>TUNGSTENFILAMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUNGSTENFILAMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUNGSTENFILAMENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUNGSTENFILAMENT = 6;

	/**
	 * The '<em><b>METALHALIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>METALHALIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METALHALIDE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int METALHALIDE = 7;

	/**
	 * The '<em><b>LOWPRESSURESODIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWPRESSURESODIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWPRESSURESODIUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWPRESSURESODIUM = 8;

	/**
	 * The '<em><b>HIGHPRESSURESODIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIGHPRESSURESODIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGHPRESSURESODIUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGHPRESSURESODIUM = 9;

	/**
	 * The '<em><b>LIGHTEMITTINGDIODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTEMITTINGDIODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTEMITTINGDIODE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTEMITTINGDIODE = 10;

	/**
	 * The '<em><b>FLUORESCENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLUORESCENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLUORESCENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLUORESCENT = 11;

	/**
	 * An array of all the '<em><b>Ifc Light Emission Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcLightEmissionSourceEnum[] VALUES_ARRAY =
		new IfcLightEmissionSourceEnum[]
		{
			NULL_LITERAL,
			LOWVOLTAGEHALOGEN_LITERAL,
			MAINVOLTAGEHALOGEN_LITERAL,
			HIGHPRESSUREMERCURY_LITERAL,
			COMPACTFLUORESCENT_LITERAL,
			NOTDEFINED_LITERAL,
			TUNGSTENFILAMENT_LITERAL,
			METALHALIDE_LITERAL,
			LOWPRESSURESODIUM_LITERAL,
			HIGHPRESSURESODIUM_LITERAL,
			LIGHTEMITTINGDIODE_LITERAL,
			FLUORESCENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Light Emission Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcLightEmissionSourceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Light Emission Source Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcLightEmissionSourceEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcLightEmissionSourceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Light Emission Source Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcLightEmissionSourceEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcLightEmissionSourceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Light Emission Source Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcLightEmissionSourceEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case LOWVOLTAGEHALOGEN: return LOWVOLTAGEHALOGEN_LITERAL;
			case MAINVOLTAGEHALOGEN: return MAINVOLTAGEHALOGEN_LITERAL;
			case HIGHPRESSUREMERCURY: return HIGHPRESSUREMERCURY_LITERAL;
			case COMPACTFLUORESCENT: return COMPACTFLUORESCENT_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case TUNGSTENFILAMENT: return TUNGSTENFILAMENT_LITERAL;
			case METALHALIDE: return METALHALIDE_LITERAL;
			case LOWPRESSURESODIUM: return LOWPRESSURESODIUM_LITERAL;
			case HIGHPRESSURESODIUM: return HIGHPRESSURESODIUM_LITERAL;
			case LIGHTEMITTINGDIODE: return LIGHTEMITTINGDIODE_LITERAL;
			case FLUORESCENT: return FLUORESCENT_LITERAL;
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
	private IfcLightEmissionSourceEnum(int value, String name, String literal)
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
	
} //IfcLightEmissionSourceEnum
