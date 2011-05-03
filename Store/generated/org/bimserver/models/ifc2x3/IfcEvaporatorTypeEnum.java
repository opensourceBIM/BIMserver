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
 * A representation of the literals of the enumeration '<em><b>Ifc Evaporator Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEvaporatorTypeEnum()
 * @model
 * @generated
 */
public enum IfcEvaporatorTypeEnum implements Enumerator
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
	 * The '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOODEDSHELLANDTUBE
	 * @generated
	 * @ordered
	 */
	FLOODEDSHELLANDTUBE_LITERAL(2, "FLOODEDSHELLANDTUBE", "FLOODEDSHELLANDTUBE"),

	/**
	 * The '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONTUBEINTUBE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONTUBEINTUBE_LITERAL(3, "DIRECTEXPANSIONTUBEINTUBE", "DIRECTEXPANSIONTUBEINTUBE"),

	/**
	 * The '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONBRAZEDPLATE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONBRAZEDPLATE_LITERAL(4, "DIRECTEXPANSIONBRAZEDPLATE", "DIRECTEXPANSIONBRAZEDPLATE"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(5, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONSHELLANDTUBE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONSHELLANDTUBE_LITERAL(6, "DIRECTEXPANSIONSHELLANDTUBE", "DIRECTEXPANSIONSHELLANDTUBE"),

	/**
	 * The '<em><b>SHELLANDCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHELLANDCOIL
	 * @generated
	 * @ordered
	 */
	SHELLANDCOIL_LITERAL(7, "SHELLANDCOIL", "SHELLANDCOIL");

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
	 * The '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOODEDSHELLANDTUBE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOODEDSHELLANDTUBE = 2;

	/**
	 * The '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONTUBEINTUBE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONTUBEINTUBE = 3;

	/**
	 * The '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONBRAZEDPLATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONBRAZEDPLATE = 4;

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
	public static final int USERDEFINED = 5;

	/**
	 * The '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONSHELLANDTUBE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONSHELLANDTUBE = 6;

	/**
	 * The '<em><b>SHELLANDCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHELLANDCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHELLANDCOIL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHELLANDCOIL = 7;

	/**
	 * An array of all the '<em><b>Ifc Evaporator Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcEvaporatorTypeEnum[] VALUES_ARRAY =
		new IfcEvaporatorTypeEnum[]
		{
			NULL_LITERAL,
			NOTDEFINED_LITERAL,
			FLOODEDSHELLANDTUBE_LITERAL,
			DIRECTEXPANSIONTUBEINTUBE_LITERAL,
			DIRECTEXPANSIONBRAZEDPLATE_LITERAL,
			USERDEFINED_LITERAL,
			DIRECTEXPANSIONSHELLANDTUBE_LITERAL,
			SHELLANDCOIL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Evaporator Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcEvaporatorTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcEvaporatorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcEvaporatorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case FLOODEDSHELLANDTUBE: return FLOODEDSHELLANDTUBE_LITERAL;
			case DIRECTEXPANSIONTUBEINTUBE: return DIRECTEXPANSIONTUBEINTUBE_LITERAL;
			case DIRECTEXPANSIONBRAZEDPLATE: return DIRECTEXPANSIONBRAZEDPLATE_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case DIRECTEXPANSIONSHELLANDTUBE: return DIRECTEXPANSIONSHELLANDTUBE_LITERAL;
			case SHELLANDCOIL: return SHELLANDCOIL_LITERAL;
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
	private IfcEvaporatorTypeEnum(int value, String name, String literal)
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
	
} //IfcEvaporatorTypeEnum
