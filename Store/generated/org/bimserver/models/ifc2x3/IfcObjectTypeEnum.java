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
 * A representation of the literals of the enumeration '<em><b>Ifc Object Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectTypeEnum()
 * @model
 * @generated
 */
public enum IfcObjectTypeEnum implements Enumerator
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
	 * The '<em><b>GROUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GROUP
	 * @generated
	 * @ordered
	 */
	GROUP_LITERAL(1, "GROUP", "GROUP"),

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
	 * The '<em><b>CONTROL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL
	 * @generated
	 * @ordered
	 */
	CONTROL_LITERAL(3, "CONTROL", "CONTROL"),

	/**
	 * The '<em><b>PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECT
	 * @generated
	 * @ordered
	 */
	PROJECT_LITERAL(4, "PROJECT", "PROJECT"),

	/**
	 * The '<em><b>PROCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESS
	 * @generated
	 * @ordered
	 */
	PROCESS_LITERAL(5, "PROCESS", "PROCESS"),

	/**
	 * The '<em><b>RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE
	 * @generated
	 * @ordered
	 */
	RESOURCE_LITERAL(6, "RESOURCE", "RESOURCE"),

	/**
	 * The '<em><b>PRODUCT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT
	 * @generated
	 * @ordered
	 */
	PRODUCT_LITERAL(7, "PRODUCT", "PRODUCT"),

	/**
	 * The '<em><b>ACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTOR
	 * @generated
	 * @ordered
	 */
	ACTOR_LITERAL(8, "ACTOR", "ACTOR");

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
	 * The '<em><b>GROUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GROUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GROUP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GROUP = 1;

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
	 * The '<em><b>CONTROL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTROL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL = 3;

	/**
	 * The '<em><b>PROJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROJECT = 4;

	/**
	 * The '<em><b>PROCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROCESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROCESS = 5;

	/**
	 * The '<em><b>RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESOURCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE = 6;

	/**
	 * The '<em><b>PRODUCT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRODUCT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT = 7;

	/**
	 * The '<em><b>ACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTOR = 8;

	/**
	 * An array of all the '<em><b>Ifc Object Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcObjectTypeEnum[] VALUES_ARRAY =
		new IfcObjectTypeEnum[]
		{
			NULL_LITERAL,
			GROUP_LITERAL,
			NOTDEFINED_LITERAL,
			CONTROL_LITERAL,
			PROJECT_LITERAL,
			PROCESS_LITERAL,
			RESOURCE_LITERAL,
			PRODUCT_LITERAL,
			ACTOR_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Object Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcObjectTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Object Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcObjectTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcObjectTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Object Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcObjectTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcObjectTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Object Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcObjectTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case GROUP: return GROUP_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case CONTROL: return CONTROL_LITERAL;
			case PROJECT: return PROJECT_LITERAL;
			case PROCESS: return PROCESS_LITERAL;
			case RESOURCE: return RESOURCE_LITERAL;
			case PRODUCT: return PRODUCT_LITERAL;
			case ACTOR: return ACTOR_LITERAL;
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
	private IfcObjectTypeEnum(int value, String name, String literal)
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
	
} //IfcObjectTypeEnum
