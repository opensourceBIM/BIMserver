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
 * A representation of the literals of the enumeration '<em><b>Ifc Project Order Record Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProjectOrderRecordTypeEnum()
 * @model
 * @generated
 */
public enum IfcProjectOrderRecordTypeEnum implements Enumerator
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
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(1, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>MAINTENANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAINTENANCE
	 * @generated
	 * @ordered
	 */
	MAINTENANCE_LITERAL(2, "MAINTENANCE", "MAINTENANCE"),

	/**
	 * The '<em><b>PURCHASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURCHASE
	 * @generated
	 * @ordered
	 */
	PURCHASE_LITERAL(3, "PURCHASE", "PURCHASE"),

	/**
	 * The '<em><b>WORK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WORK
	 * @generated
	 * @ordered
	 */
	WORK_LITERAL(4, "WORK", "WORK"),

	/**
	 * The '<em><b>MOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE
	 * @generated
	 * @ordered
	 */
	MOVE_LITERAL(5, "MOVE", "MOVE"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(6, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>CHANGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE
	 * @generated
	 * @ordered
	 */
	CHANGE_LITERAL(7, "CHANGE", "CHANGE");

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
	public static final int NOTDEFINED = 1;

	/**
	 * The '<em><b>MAINTENANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAINTENANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAINTENANCE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAINTENANCE = 2;

	/**
	 * The '<em><b>PURCHASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURCHASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PURCHASE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURCHASE = 3;

	/**
	 * The '<em><b>WORK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WORK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WORK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WORK = 4;

	/**
	 * The '<em><b>MOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE = 5;

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
	public static final int USERDEFINED = 6;

	/**
	 * The '<em><b>CHANGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE = 7;

	/**
	 * An array of all the '<em><b>Ifc Project Order Record Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcProjectOrderRecordTypeEnum[] VALUES_ARRAY =
		new IfcProjectOrderRecordTypeEnum[]
		{
			NULL_LITERAL,
			NOTDEFINED_LITERAL,
			MAINTENANCE_LITERAL,
			PURCHASE_LITERAL,
			WORK_LITERAL,
			MOVE_LITERAL,
			USERDEFINED_LITERAL,
			CHANGE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Project Order Record Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcProjectOrderRecordTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Project Order Record Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProjectOrderRecordTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcProjectOrderRecordTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Project Order Record Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProjectOrderRecordTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcProjectOrderRecordTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Project Order Record Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProjectOrderRecordTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case MAINTENANCE: return MAINTENANCE_LITERAL;
			case PURCHASE: return PURCHASE_LITERAL;
			case WORK: return WORK_LITERAL;
			case MOVE: return MOVE_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case CHANGE: return CHANGE_LITERAL;
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
	private IfcProjectOrderRecordTypeEnum(int value, String name, String literal)
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
	
} //IfcProjectOrderRecordTypeEnum
