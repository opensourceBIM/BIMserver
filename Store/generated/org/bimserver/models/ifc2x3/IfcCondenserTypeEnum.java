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
 * A representation of the literals of the enumeration '<em><b>Ifc Condenser Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCondenserTypeEnum()
 * @model
 * @generated
 */
public enum IfcCondenserTypeEnum implements Enumerator
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
	 * The '<em><b>EVAPORATIVECOOLED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVAPORATIVECOOLED
	 * @generated
	 * @ordered
	 */
	EVAPORATIVECOOLED_LITERAL(1, "EVAPORATIVECOOLED", "EVAPORATIVECOOLED"),

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
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(3, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>WATERCOOLEDSHELLTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDSHELLTUBE
	 * @generated
	 * @ordered
	 */
	WATERCOOLEDSHELLTUBE_LITERAL(4, "WATERCOOLEDSHELLTUBE", "WATERCOOLEDSHELLTUBE"),

	/**
	 * The '<em><b>WATERCOOLEDTUBEINTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDTUBEINTUBE
	 * @generated
	 * @ordered
	 */
	WATERCOOLEDTUBEINTUBE_LITERAL(5, "WATERCOOLEDTUBEINTUBE", "WATERCOOLEDTUBEINTUBE"),

	/**
	 * The '<em><b>WATERCOOLEDBRAZEDPLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDBRAZEDPLATE
	 * @generated
	 * @ordered
	 */
	WATERCOOLEDBRAZEDPLATE_LITERAL(6, "WATERCOOLEDBRAZEDPLATE", "WATERCOOLEDBRAZEDPLATE"),

	/**
	 * The '<em><b>WATERCOOLEDSHELLCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDSHELLCOIL
	 * @generated
	 * @ordered
	 */
	WATERCOOLEDSHELLCOIL_LITERAL(7, "WATERCOOLEDSHELLCOIL", "WATERCOOLEDSHELLCOIL"),

	/**
	 * The '<em><b>AIRCOOLED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIRCOOLED
	 * @generated
	 * @ordered
	 */
	AIRCOOLED_LITERAL(8, "AIRCOOLED", "AIRCOOLED");

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
	 * The '<em><b>EVAPORATIVECOOLED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EVAPORATIVECOOLED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVAPORATIVECOOLED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EVAPORATIVECOOLED = 1;

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
	public static final int USERDEFINED = 3;

	/**
	 * The '<em><b>WATERCOOLEDSHELLTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLEDSHELLTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDSHELLTUBE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLEDSHELLTUBE = 4;

	/**
	 * The '<em><b>WATERCOOLEDTUBEINTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLEDTUBEINTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDTUBEINTUBE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLEDTUBEINTUBE = 5;

	/**
	 * The '<em><b>WATERCOOLEDBRAZEDPLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLEDBRAZEDPLATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDBRAZEDPLATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLEDBRAZEDPLATE = 6;

	/**
	 * The '<em><b>WATERCOOLEDSHELLCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLEDSHELLCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLEDSHELLCOIL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLEDSHELLCOIL = 7;

	/**
	 * The '<em><b>AIRCOOLED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIRCOOLED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIRCOOLED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIRCOOLED = 8;

	/**
	 * An array of all the '<em><b>Ifc Condenser Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCondenserTypeEnum[] VALUES_ARRAY =
		new IfcCondenserTypeEnum[]
		{
			NULL_LITERAL,
			EVAPORATIVECOOLED_LITERAL,
			NOTDEFINED_LITERAL,
			USERDEFINED_LITERAL,
			WATERCOOLEDSHELLTUBE_LITERAL,
			WATERCOOLEDTUBEINTUBE_LITERAL,
			WATERCOOLEDBRAZEDPLATE_LITERAL,
			WATERCOOLEDSHELLCOIL_LITERAL,
			AIRCOOLED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Condenser Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCondenserTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Condenser Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCondenserTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCondenserTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Condenser Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCondenserTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCondenserTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Condenser Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCondenserTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case EVAPORATIVECOOLED: return EVAPORATIVECOOLED_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case WATERCOOLEDSHELLTUBE: return WATERCOOLEDSHELLTUBE_LITERAL;
			case WATERCOOLEDTUBEINTUBE: return WATERCOOLEDTUBEINTUBE_LITERAL;
			case WATERCOOLEDBRAZEDPLATE: return WATERCOOLEDBRAZEDPLATE_LITERAL;
			case WATERCOOLEDSHELLCOIL: return WATERCOOLEDSHELLCOIL_LITERAL;
			case AIRCOOLED: return AIRCOOLED_LITERAL;
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
	private IfcCondenserTypeEnum(int value, String name, String literal)
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
	
} //IfcCondenserTypeEnum
