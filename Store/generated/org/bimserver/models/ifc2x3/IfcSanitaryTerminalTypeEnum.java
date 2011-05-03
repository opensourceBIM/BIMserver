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
 * A representation of the literals of the enumeration '<em><b>Ifc Sanitary Terminal Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSanitaryTerminalTypeEnum()
 * @model
 * @generated
 */
public enum IfcSanitaryTerminalTypeEnum implements Enumerator
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
	 * The '<em><b>TOILETPAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOILETPAN
	 * @generated
	 * @ordered
	 */
	TOILETPAN_LITERAL(1, "TOILETPAN", "TOILETPAN"),

	/**
	 * The '<em><b>BATH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BATH
	 * @generated
	 * @ordered
	 */
	BATH_LITERAL(2, "BATH", "BATH"),

	/**
	 * The '<em><b>CISTERN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CISTERN
	 * @generated
	 * @ordered
	 */
	CISTERN_LITERAL(3, "CISTERN", "CISTERN"),

	/**
	 * The '<em><b>BIDET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIDET
	 * @generated
	 * @ordered
	 */
	BIDET_LITERAL(4, "BIDET", "BIDET"),

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
	 * The '<em><b>WASHHANDBASIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASHHANDBASIN
	 * @generated
	 * @ordered
	 */
	WASHHANDBASIN_LITERAL(6, "WASHHANDBASIN", "WASHHANDBASIN"),

	/**
	 * The '<em><b>SANITARYFOUNTAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SANITARYFOUNTAIN
	 * @generated
	 * @ordered
	 */
	SANITARYFOUNTAIN_LITERAL(7, "SANITARYFOUNTAIN", "SANITARYFOUNTAIN"),

	/**
	 * The '<em><b>URINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URINAL
	 * @generated
	 * @ordered
	 */
	URINAL_LITERAL(8, "URINAL", "URINAL"),

	/**
	 * The '<em><b>SINK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINK
	 * @generated
	 * @ordered
	 */
	SINK_LITERAL(9, "SINK", "SINK"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(10, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>WCSEAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WCSEAT
	 * @generated
	 * @ordered
	 */
	WCSEAT_LITERAL(11, "WCSEAT", "WCSEAT"),

	/**
	 * The '<em><b>SHOWER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOWER
	 * @generated
	 * @ordered
	 */
	SHOWER_LITERAL(12, "SHOWER", "SHOWER");

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
	 * The '<em><b>TOILETPAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOILETPAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOILETPAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOILETPAN = 1;

	/**
	 * The '<em><b>BATH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BATH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BATH_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BATH = 2;

	/**
	 * The '<em><b>CISTERN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CISTERN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CISTERN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CISTERN = 3;

	/**
	 * The '<em><b>BIDET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIDET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIDET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIDET = 4;

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
	 * The '<em><b>WASHHANDBASIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WASHHANDBASIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WASHHANDBASIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WASHHANDBASIN = 6;

	/**
	 * The '<em><b>SANITARYFOUNTAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SANITARYFOUNTAIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SANITARYFOUNTAIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SANITARYFOUNTAIN = 7;

	/**
	 * The '<em><b>URINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>URINAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #URINAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int URINAL = 8;

	/**
	 * The '<em><b>SINK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINK = 9;

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
	public static final int USERDEFINED = 10;

	/**
	 * The '<em><b>WCSEAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WCSEAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WCSEAT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WCSEAT = 11;

	/**
	 * The '<em><b>SHOWER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHOWER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOWER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHOWER = 12;

	/**
	 * An array of all the '<em><b>Ifc Sanitary Terminal Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSanitaryTerminalTypeEnum[] VALUES_ARRAY =
		new IfcSanitaryTerminalTypeEnum[]
		{
			NULL_LITERAL,
			TOILETPAN_LITERAL,
			BATH_LITERAL,
			CISTERN_LITERAL,
			BIDET_LITERAL,
			NOTDEFINED_LITERAL,
			WASHHANDBASIN_LITERAL,
			SANITARYFOUNTAIN_LITERAL,
			URINAL_LITERAL,
			SINK_LITERAL,
			USERDEFINED_LITERAL,
			WCSEAT_LITERAL,
			SHOWER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Sanitary Terminal Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSanitaryTerminalTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Sanitary Terminal Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSanitaryTerminalTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSanitaryTerminalTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sanitary Terminal Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSanitaryTerminalTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSanitaryTerminalTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sanitary Terminal Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSanitaryTerminalTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case TOILETPAN: return TOILETPAN_LITERAL;
			case BATH: return BATH_LITERAL;
			case CISTERN: return CISTERN_LITERAL;
			case BIDET: return BIDET_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case WASHHANDBASIN: return WASHHANDBASIN_LITERAL;
			case SANITARYFOUNTAIN: return SANITARYFOUNTAIN_LITERAL;
			case URINAL: return URINAL_LITERAL;
			case SINK: return SINK_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case WCSEAT: return WCSEAT_LITERAL;
			case SHOWER: return SHOWER_LITERAL;
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
	private IfcSanitaryTerminalTypeEnum(int value, String name, String literal)
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
	
} //IfcSanitaryTerminalTypeEnum
