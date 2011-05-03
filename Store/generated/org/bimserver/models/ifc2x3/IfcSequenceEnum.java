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
 * A representation of the literals of the enumeration '<em><b>Ifc Sequence Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSequenceEnum()
 * @model
 * @generated
 */
public enum IfcSequenceEnum implements Enumerator
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
	 * The '<em><b>FINISH START</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISH_START
	 * @generated
	 * @ordered
	 */
	FINISH_START_LITERAL(1, "FINISH_START", "FINISH_START"),

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
	 * The '<em><b>FINISH FINISH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISH_FINISH
	 * @generated
	 * @ordered
	 */
	FINISH_FINISH_LITERAL(3, "FINISH_FINISH", "FINISH_FINISH"),

	/**
	 * The '<em><b>START START</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_START
	 * @generated
	 * @ordered
	 */
	START_START_LITERAL(4, "START_START", "START_START"),

	/**
	 * The '<em><b>START FINISH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_FINISH
	 * @generated
	 * @ordered
	 */
	START_FINISH_LITERAL(5, "START_FINISH", "START_FINISH");

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
	 * The '<em><b>FINISH START</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINISH START</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISH_START_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINISH_START = 1;

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
	 * The '<em><b>FINISH FINISH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINISH FINISH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISH_FINISH_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINISH_FINISH = 3;

	/**
	 * The '<em><b>START START</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START START</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_START_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_START = 4;

	/**
	 * The '<em><b>START FINISH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START FINISH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_FINISH_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_FINISH = 5;

	/**
	 * An array of all the '<em><b>Ifc Sequence Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSequenceEnum[] VALUES_ARRAY =
		new IfcSequenceEnum[]
		{
			NULL_LITERAL,
			FINISH_START_LITERAL,
			NOTDEFINED_LITERAL,
			FINISH_FINISH_LITERAL,
			START_START_LITERAL,
			START_FINISH_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Sequence Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSequenceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Sequence Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSequenceEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSequenceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sequence Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSequenceEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSequenceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sequence Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSequenceEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case FINISH_START: return FINISH_START_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case FINISH_FINISH: return FINISH_FINISH_LITERAL;
			case START_START: return START_START_LITERAL;
			case START_FINISH: return START_FINISH_LITERAL;
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
	private IfcSequenceEnum(int value, String name, String literal)
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
	
} //IfcSequenceEnum
