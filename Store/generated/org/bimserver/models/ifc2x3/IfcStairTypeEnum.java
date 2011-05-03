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
 * A representation of the literals of the enumeration '<em><b>Ifc Stair Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairTypeEnum()
 * @model
 * @generated
 */
public enum IfcStairTypeEnum implements Enumerator
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
	 * The '<em><b>SPIRAL STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPIRAL_STAIR
	 * @generated
	 * @ordered
	 */
	SPIRAL_STAIR_LITERAL(1, "SPIRAL_STAIR", "SPIRAL_STAIR"),

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
	 * The '<em><b>QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUARTER_WINDING_STAIR
	 * @generated
	 * @ordered
	 */
	QUARTER_WINDING_STAIR_LITERAL(3, "QUARTER_WINDING_STAIR", "QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>HALF WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_WINDING_STAIR
	 * @generated
	 * @ordered
	 */
	HALF_WINDING_STAIR_LITERAL(4, "HALF_WINDING_STAIR", "HALF_WINDING_STAIR"),

	/**
	 * The '<em><b>STRAIGHT RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_RUN_STAIR
	 * @generated
	 * @ordered
	 */
	STRAIGHT_RUN_STAIR_LITERAL(5, "STRAIGHT_RUN_STAIR", "STRAIGHT_RUN_STAIR"),

	/**
	 * The '<em><b>TWO CURVED RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_CURVED_RUN_STAIR
	 * @generated
	 * @ordered
	 */
	TWO_CURVED_RUN_STAIR_LITERAL(6, "TWO_CURVED_RUN_STAIR", "TWO_CURVED_RUN_STAIR"),

	/**
	 * The '<em><b>HALF TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_TURN_STAIR
	 * @generated
	 * @ordered
	 */
	HALF_TURN_STAIR_LITERAL(7, "HALF_TURN_STAIR", "HALF_TURN_STAIR"),

	/**
	 * The '<em><b>CURVED RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURVED_RUN_STAIR
	 * @generated
	 * @ordered
	 */
	CURVED_RUN_STAIR_LITERAL(8, "CURVED_RUN_STAIR", "CURVED_RUN_STAIR"),

	/**
	 * The '<em><b>DOUBLE RETURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_RETURN_STAIR
	 * @generated
	 * @ordered
	 */
	DOUBLE_RETURN_STAIR_LITERAL(9, "DOUBLE_RETURN_STAIR", "DOUBLE_RETURN_STAIR"),

	/**
	 * The '<em><b>QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUARTER_TURN_STAIR
	 * @generated
	 * @ordered
	 */
	QUARTER_TURN_STAIR_LITERAL(10, "QUARTER_TURN_STAIR", "QUARTER_TURN_STAIR"),

	/**
	 * The '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_WINDING_STAIR
	 * @generated
	 * @ordered
	 */
	TWO_QUARTER_WINDING_STAIR_LITERAL(11, "TWO_QUARTER_WINDING_STAIR", "TWO_QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>TWO QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_TURN_STAIR
	 * @generated
	 * @ordered
	 */
	TWO_QUARTER_TURN_STAIR_LITERAL(12, "TWO_QUARTER_TURN_STAIR", "TWO_QUARTER_TURN_STAIR"),

	/**
	 * The '<em><b>THREE QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_TURN_STAIR
	 * @generated
	 * @ordered
	 */
	THREE_QUARTER_TURN_STAIR_LITERAL(13, "THREE_QUARTER_TURN_STAIR", "THREE_QUARTER_TURN_STAIR"),

	/**
	 * The '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_STRAIGHT_RUN_STAIR
	 * @generated
	 * @ordered
	 */
	TWO_STRAIGHT_RUN_STAIR_LITERAL(14, "TWO_STRAIGHT_RUN_STAIR", "TWO_STRAIGHT_RUN_STAIR"),

	/**
	 * The '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_WINDING_STAIR
	 * @generated
	 * @ordered
	 */
	THREE_QUARTER_WINDING_STAIR_LITERAL(15, "THREE_QUARTER_WINDING_STAIR", "THREE_QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(16, "USERDEFINED", "USERDEFINED");

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
	 * The '<em><b>SPIRAL STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPIRAL STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPIRAL_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPIRAL_STAIR = 1;

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
	 * The '<em><b>QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUARTER_WINDING_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUARTER_WINDING_STAIR = 3;

	/**
	 * The '<em><b>HALF WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HALF WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_WINDING_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HALF_WINDING_STAIR = 4;

	/**
	 * The '<em><b>STRAIGHT RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRAIGHT RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_RUN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRAIGHT_RUN_STAIR = 5;

	/**
	 * The '<em><b>TWO CURVED RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO CURVED RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_CURVED_RUN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_CURVED_RUN_STAIR = 6;

	/**
	 * The '<em><b>HALF TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HALF TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_TURN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HALF_TURN_STAIR = 7;

	/**
	 * The '<em><b>CURVED RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CURVED RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CURVED_RUN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CURVED_RUN_STAIR = 8;

	/**
	 * The '<em><b>DOUBLE RETURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE RETURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_RETURN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_RETURN_STAIR = 9;

	/**
	 * The '<em><b>QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUARTER_TURN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUARTER_TURN_STAIR = 10;

	/**
	 * The '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_WINDING_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_QUARTER_WINDING_STAIR = 11;

	/**
	 * The '<em><b>TWO QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_TURN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_QUARTER_TURN_STAIR = 12;

	/**
	 * The '<em><b>THREE QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREE QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_TURN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THREE_QUARTER_TURN_STAIR = 13;

	/**
	 * The '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_STRAIGHT_RUN_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_STRAIGHT_RUN_STAIR = 14;

	/**
	 * The '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_WINDING_STAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THREE_QUARTER_WINDING_STAIR = 15;

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
	public static final int USERDEFINED = 16;

	/**
	 * An array of all the '<em><b>Ifc Stair Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcStairTypeEnum[] VALUES_ARRAY =
		new IfcStairTypeEnum[]
		{
			NULL_LITERAL,
			SPIRAL_STAIR_LITERAL,
			NOTDEFINED_LITERAL,
			QUARTER_WINDING_STAIR_LITERAL,
			HALF_WINDING_STAIR_LITERAL,
			STRAIGHT_RUN_STAIR_LITERAL,
			TWO_CURVED_RUN_STAIR_LITERAL,
			HALF_TURN_STAIR_LITERAL,
			CURVED_RUN_STAIR_LITERAL,
			DOUBLE_RETURN_STAIR_LITERAL,
			QUARTER_TURN_STAIR_LITERAL,
			TWO_QUARTER_WINDING_STAIR_LITERAL,
			TWO_QUARTER_TURN_STAIR_LITERAL,
			THREE_QUARTER_TURN_STAIR_LITERAL,
			TWO_STRAIGHT_RUN_STAIR_LITERAL,
			THREE_QUARTER_WINDING_STAIR_LITERAL,
			USERDEFINED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Stair Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcStairTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcStairTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcStairTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcStairTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcStairTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcStairTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case SPIRAL_STAIR: return SPIRAL_STAIR_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case QUARTER_WINDING_STAIR: return QUARTER_WINDING_STAIR_LITERAL;
			case HALF_WINDING_STAIR: return HALF_WINDING_STAIR_LITERAL;
			case STRAIGHT_RUN_STAIR: return STRAIGHT_RUN_STAIR_LITERAL;
			case TWO_CURVED_RUN_STAIR: return TWO_CURVED_RUN_STAIR_LITERAL;
			case HALF_TURN_STAIR: return HALF_TURN_STAIR_LITERAL;
			case CURVED_RUN_STAIR: return CURVED_RUN_STAIR_LITERAL;
			case DOUBLE_RETURN_STAIR: return DOUBLE_RETURN_STAIR_LITERAL;
			case QUARTER_TURN_STAIR: return QUARTER_TURN_STAIR_LITERAL;
			case TWO_QUARTER_WINDING_STAIR: return TWO_QUARTER_WINDING_STAIR_LITERAL;
			case TWO_QUARTER_TURN_STAIR: return TWO_QUARTER_TURN_STAIR_LITERAL;
			case THREE_QUARTER_TURN_STAIR: return THREE_QUARTER_TURN_STAIR_LITERAL;
			case TWO_STRAIGHT_RUN_STAIR: return TWO_STRAIGHT_RUN_STAIR_LITERAL;
			case THREE_QUARTER_WINDING_STAIR: return THREE_QUARTER_WINDING_STAIR_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
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
	private IfcStairTypeEnum(int value, String name, String literal)
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
	
} //IfcStairTypeEnum
