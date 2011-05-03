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
 * A representation of the literals of the enumeration '<em><b>Ifc Compressor Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompressorTypeEnum()
 * @model
 * @generated
 */
public enum IfcCompressorTypeEnum implements Enumerator
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
	 * The '<em><b>BOOSTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOSTER
	 * @generated
	 * @ordered
	 */
	BOOSTER_LITERAL(1, "BOOSTER", "BOOSTER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>SINGLESCREW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLESCREW
	 * @generated
	 * @ordered
	 */
	SINGLESCREW_LITERAL(3, "SINGLESCREW", "SINGLESCREW"),

	/**
	 * The '<em><b>ROTARYVANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARYVANE
	 * @generated
	 * @ordered
	 */
	ROTARYVANE_LITERAL(4, "ROTARYVANE", "ROTARYVANE"),

	/**
	 * The '<em><b>OPENTYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPENTYPE
	 * @generated
	 * @ordered
	 */
	OPENTYPE_LITERAL(5, "OPENTYPE", "OPENTYPE"),

	/**
	 * The '<em><b>SINGLESTAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLESTAGE
	 * @generated
	 * @ordered
	 */
	SINGLESTAGE_LITERAL(6, "SINGLESTAGE", "SINGLESTAGE"),

	/**
	 * The '<em><b>HERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERMETIC
	 * @generated
	 * @ordered
	 */
	HERMETIC_LITERAL(7, "HERMETIC", "HERMETIC"),

	/**
	 * The '<em><b>SEMIHERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEMIHERMETIC
	 * @generated
	 * @ordered
	 */
	SEMIHERMETIC_LITERAL(8, "SEMIHERMETIC", "SEMIHERMETIC"),

	/**
	 * The '<em><b>TWINSCREW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWINSCREW
	 * @generated
	 * @ordered
	 */
	TWINSCREW_LITERAL(9, "TWINSCREW", "TWINSCREW"),

	/**
	 * The '<em><b>ROTARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARY
	 * @generated
	 * @ordered
	 */
	ROTARY_LITERAL(10, "ROTARY", "ROTARY"),

	/**
	 * The '<em><b>SCROLL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCROLL
	 * @generated
	 * @ordered
	 */
	SCROLL_LITERAL(11, "SCROLL", "SCROLL"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(12, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ROLLINGPISTON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGPISTON
	 * @generated
	 * @ordered
	 */
	ROLLINGPISTON_LITERAL(13, "ROLLINGPISTON", "ROLLINGPISTON"),

	/**
	 * The '<em><b>WELDEDSHELLHERMETIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WELDEDSHELLHERMETIC
	 * @generated
	 * @ordered
	 */
	WELDEDSHELLHERMETIC_LITERAL(14, "WELDEDSHELLHERMETIC", "WELDEDSHELLHERMETIC"),

	/**
	 * The '<em><b>DYNAMIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC
	 * @generated
	 * @ordered
	 */
	DYNAMIC_LITERAL(15, "DYNAMIC", "DYNAMIC"),

	/**
	 * The '<em><b>RECIPROCATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECIPROCATING
	 * @generated
	 * @ordered
	 */
	RECIPROCATING_LITERAL(16, "RECIPROCATING", "RECIPROCATING"),

	/**
	 * The '<em><b>TROCHOIDAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TROCHOIDAL
	 * @generated
	 * @ordered
	 */
	TROCHOIDAL_LITERAL(17, "TROCHOIDAL", "TROCHOIDAL");

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
	 * The '<em><b>BOOSTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOSTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOSTER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOSTER = 1;

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
	public static final int NOTDEFINED = 2;

	/**
	 * The '<em><b>SINGLESCREW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLESCREW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLESCREW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLESCREW = 3;

	/**
	 * The '<em><b>ROTARYVANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARYVANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARYVANE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARYVANE = 4;

	/**
	 * The '<em><b>OPENTYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPENTYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPENTYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPENTYPE = 5;

	/**
	 * The '<em><b>SINGLESTAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLESTAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLESTAGE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLESTAGE = 6;

	/**
	 * The '<em><b>HERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HERMETIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HERMETIC = 7;

	/**
	 * The '<em><b>SEMIHERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEMIHERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEMIHERMETIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEMIHERMETIC = 8;

	/**
	 * The '<em><b>TWINSCREW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWINSCREW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWINSCREW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWINSCREW = 9;

	/**
	 * The '<em><b>ROTARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARY = 10;

	/**
	 * The '<em><b>SCROLL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCROLL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCROLL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCROLL = 11;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED = 12;

	/**
	 * The '<em><b>ROLLINGPISTON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLINGPISTON</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLINGPISTON_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLINGPISTON = 13;

	/**
	 * The '<em><b>WELDEDSHELLHERMETIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WELDEDSHELLHERMETIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WELDEDSHELLHERMETIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WELDEDSHELLHERMETIC = 14;

	/**
	 * The '<em><b>DYNAMIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DYNAMIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC = 15;

	/**
	 * The '<em><b>RECIPROCATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECIPROCATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECIPROCATING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECIPROCATING = 16;

	/**
	 * The '<em><b>TROCHOIDAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TROCHOIDAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TROCHOIDAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TROCHOIDAL = 17;

	/**
	 * An array of all the '<em><b>Ifc Compressor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCompressorTypeEnum[] VALUES_ARRAY =
		new IfcCompressorTypeEnum[]
		{
			NULL_LITERAL,
			BOOSTER_LITERAL,
			NOTDEFINED_LITERAL,
			SINGLESCREW_LITERAL,
			ROTARYVANE_LITERAL,
			OPENTYPE_LITERAL,
			SINGLESTAGE_LITERAL,
			HERMETIC_LITERAL,
			SEMIHERMETIC_LITERAL,
			TWINSCREW_LITERAL,
			ROTARY_LITERAL,
			SCROLL_LITERAL,
			USERDEFINED_LITERAL,
			ROLLINGPISTON_LITERAL,
			WELDEDSHELLHERMETIC_LITERAL,
			DYNAMIC_LITERAL,
			RECIPROCATING_LITERAL,
			TROCHOIDAL_LITERAL,
		};

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
	 * @generated
	 */
	public static IfcCompressorTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCompressorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Compressor Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCompressorTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCompressorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Compressor Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCompressorTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case BOOSTER: return BOOSTER_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case SINGLESCREW: return SINGLESCREW_LITERAL;
			case ROTARYVANE: return ROTARYVANE_LITERAL;
			case OPENTYPE: return OPENTYPE_LITERAL;
			case SINGLESTAGE: return SINGLESTAGE_LITERAL;
			case HERMETIC: return HERMETIC_LITERAL;
			case SEMIHERMETIC: return SEMIHERMETIC_LITERAL;
			case TWINSCREW: return TWINSCREW_LITERAL;
			case ROTARY: return ROTARY_LITERAL;
			case SCROLL: return SCROLL_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case ROLLINGPISTON: return ROLLINGPISTON_LITERAL;
			case WELDEDSHELLHERMETIC: return WELDEDSHELLHERMETIC_LITERAL;
			case DYNAMIC: return DYNAMIC_LITERAL;
			case RECIPROCATING: return RECIPROCATING_LITERAL;
			case TROCHOIDAL: return TROCHOIDAL_LITERAL;
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
	private IfcCompressorTypeEnum(int value, String name, String literal)
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
	
} //IfcCompressorTypeEnum
