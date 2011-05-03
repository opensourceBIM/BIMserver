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
 * A representation of the literals of the enumeration '<em><b>Ifc Door Style Construction Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyleConstructionEnum()
 * @model
 * @generated
 */
public enum IfcDoorStyleConstructionEnum implements Enumerator
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
	 * The '<em><b>ALUMINIUM WOOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM_WOOD
	 * @generated
	 * @ordered
	 */
	ALUMINIUM_WOOD_LITERAL(1, "ALUMINIUM_WOOD", "ALUMINIUM_WOOD"),

	/**
	 * The '<em><b>HIGH GRADE STEEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGH_GRADE_STEEL
	 * @generated
	 * @ordered
	 */
	HIGH_GRADE_STEEL_LITERAL(2, "HIGH_GRADE_STEEL", "HIGH_GRADE_STEEL"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ALUMINIUM PLASTIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM_PLASTIC
	 * @generated
	 * @ordered
	 */
	ALUMINIUM_PLASTIC_LITERAL(4, "ALUMINIUM_PLASTIC", "ALUMINIUM_PLASTIC"),

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
	 * The '<em><b>PLASTIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLASTIC
	 * @generated
	 * @ordered
	 */
	PLASTIC_LITERAL(6, "PLASTIC", "PLASTIC"),

	/**
	 * The '<em><b>WOOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WOOD
	 * @generated
	 * @ordered
	 */
	WOOD_LITERAL(7, "WOOD", "WOOD"),

	/**
	 * The '<em><b>ALUMINIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM
	 * @generated
	 * @ordered
	 */
	ALUMINIUM_LITERAL(8, "ALUMINIUM", "ALUMINIUM"),

	/**
	 * The '<em><b>STEEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEEL
	 * @generated
	 * @ordered
	 */
	STEEL_LITERAL(9, "STEEL", "STEEL");

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
	 * The '<em><b>ALUMINIUM WOOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALUMINIUM WOOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM_WOOD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALUMINIUM_WOOD = 1;

	/**
	 * The '<em><b>HIGH GRADE STEEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIGH GRADE STEEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGH_GRADE_STEEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGH_GRADE_STEEL = 2;

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
	public static final int NOTDEFINED = 3;

	/**
	 * The '<em><b>ALUMINIUM PLASTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALUMINIUM PLASTIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM_PLASTIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALUMINIUM_PLASTIC = 4;

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
	 * The '<em><b>PLASTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLASTIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLASTIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLASTIC = 6;

	/**
	 * The '<em><b>WOOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WOOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WOOD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WOOD = 7;

	/**
	 * The '<em><b>ALUMINIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALUMINIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALUMINIUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALUMINIUM = 8;

	/**
	 * The '<em><b>STEEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEEL = 9;

	/**
	 * An array of all the '<em><b>Ifc Door Style Construction Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcDoorStyleConstructionEnum[] VALUES_ARRAY =
		new IfcDoorStyleConstructionEnum[]
		{
			NULL_LITERAL,
			ALUMINIUM_WOOD_LITERAL,
			HIGH_GRADE_STEEL_LITERAL,
			NOTDEFINED_LITERAL,
			ALUMINIUM_PLASTIC_LITERAL,
			USERDEFINED_LITERAL,
			PLASTIC_LITERAL,
			WOOD_LITERAL,
			ALUMINIUM_LITERAL,
			STEEL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Door Style Construction Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcDoorStyleConstructionEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Door Style Construction Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleConstructionEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDoorStyleConstructionEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Construction Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleConstructionEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDoorStyleConstructionEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Construction Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleConstructionEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case ALUMINIUM_WOOD: return ALUMINIUM_WOOD_LITERAL;
			case HIGH_GRADE_STEEL: return HIGH_GRADE_STEEL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case ALUMINIUM_PLASTIC: return ALUMINIUM_PLASTIC_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case PLASTIC: return PLASTIC_LITERAL;
			case WOOD: return WOOD_LITERAL;
			case ALUMINIUM: return ALUMINIUM_LITERAL;
			case STEEL: return STEEL_LITERAL;
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
	private IfcDoorStyleConstructionEnum(int value, String name, String literal)
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
	
} //IfcDoorStyleConstructionEnum
