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
 * A representation of the literals of the enumeration '<em><b>Ifc Door Style Operation Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyleOperationEnum()
 * @model
 * @generated
 */
public enum IfcDoorStyleOperationEnum implements Enumerator
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
	 * The '<em><b>SINGLE SWING LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_LEFT
	 * @generated
	 * @ordered
	 */
	SINGLE_SWING_LEFT_LITERAL(1, "SINGLE_SWING_LEFT", "SINGLE_SWING_LEFT"),

	/**
	 * The '<em><b>FOLDING TO LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_LEFT
	 * @generated
	 * @ordered
	 */
	FOLDING_TO_LEFT_LITERAL(2, "FOLDING_TO_LEFT", "FOLDING_TO_LEFT"),

	/**
	 * The '<em><b>SINGLE SWING RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_RIGHT
	 * @generated
	 * @ordered
	 */
	SINGLE_SWING_RIGHT_LITERAL(3, "SINGLE_SWING_RIGHT", "SINGLE_SWING_RIGHT"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ROLLINGUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGUP
	 * @generated
	 * @ordered
	 */
	ROLLINGUP_LITERAL(5, "ROLLINGUP", "ROLLINGUP"),

	/**
	 * The '<em><b>DOUBLE DOOR FOLDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_FOLDING
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_FOLDING_LITERAL(6, "DOUBLE_DOOR_FOLDING", "DOUBLE_DOOR_FOLDING"),

	/**
	 * The '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_DOUBLE_SWING
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_DOUBLE_SWING_LITERAL(7, "DOUBLE_DOOR_DOUBLE_SWING", "DOUBLE_DOOR_DOUBLE_SWING"),

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SINGLE_SWING_LITERAL(8, "DOUBLE_DOOR_SINGLE_SWING", "DOUBLE_DOOR_SINGLE_SWING"),

	/**
	 * The '<em><b>SLIDING TO LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_LEFT
	 * @generated
	 * @ordered
	 */
	SLIDING_TO_LEFT_LITERAL(9, "SLIDING_TO_LEFT", "SLIDING_TO_LEFT"),

	/**
	 * The '<em><b>DOUBLE DOOR SLIDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SLIDING
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SLIDING_LITERAL(10, "DOUBLE_DOOR_SLIDING", "DOUBLE_DOOR_SLIDING"),

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_LITERAL(11, "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT", "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT"),

	/**
	 * The '<em><b>FOLDING TO RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_RIGHT
	 * @generated
	 * @ordered
	 */
	FOLDING_TO_RIGHT_LITERAL(12, "FOLDING_TO_RIGHT", "FOLDING_TO_RIGHT"),

	/**
	 * The '<em><b>REVOLVING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVOLVING
	 * @generated
	 * @ordered
	 */
	REVOLVING_LITERAL(13, "REVOLVING", "REVOLVING"),

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_LITERAL(14, "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT", "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(15, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SLIDING TO RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_RIGHT
	 * @generated
	 * @ordered
	 */
	SLIDING_TO_RIGHT_LITERAL(16, "SLIDING_TO_RIGHT", "SLIDING_TO_RIGHT"),

	/**
	 * The '<em><b>DOUBLE SWING LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_LEFT
	 * @generated
	 * @ordered
	 */
	DOUBLE_SWING_LEFT_LITERAL(17, "DOUBLE_SWING_LEFT", "DOUBLE_SWING_LEFT"),

	/**
	 * The '<em><b>DOUBLE SWING RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_RIGHT
	 * @generated
	 * @ordered
	 */
	DOUBLE_SWING_RIGHT_LITERAL(18, "DOUBLE_SWING_RIGHT", "DOUBLE_SWING_RIGHT");

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
	 * The '<em><b>SINGLE SWING LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE SWING LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_LEFT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_SWING_LEFT = 1;

	/**
	 * The '<em><b>FOLDING TO LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDING TO LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_LEFT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDING_TO_LEFT = 2;

	/**
	 * The '<em><b>SINGLE SWING RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE SWING RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_RIGHT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_SWING_RIGHT = 3;

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
	public static final int NOTDEFINED = 4;

	/**
	 * The '<em><b>ROLLINGUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLINGUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLINGUP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLINGUP = 5;

	/**
	 * The '<em><b>DOUBLE DOOR FOLDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR FOLDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_FOLDING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_FOLDING = 6;

	/**
	 * The '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_DOUBLE_SWING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_DOUBLE_SWING = 7;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING = 8;

	/**
	 * The '<em><b>SLIDING TO LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDING TO LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_LEFT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDING_TO_LEFT = 9;

	/**
	 * The '<em><b>DOUBLE DOOR SLIDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SLIDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SLIDING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SLIDING = 10;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT = 11;

	/**
	 * The '<em><b>FOLDING TO RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDING TO RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_RIGHT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDING_TO_RIGHT = 12;

	/**
	 * The '<em><b>REVOLVING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REVOLVING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REVOLVING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REVOLVING = 13;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT = 14;

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
	public static final int USERDEFINED = 15;

	/**
	 * The '<em><b>SLIDING TO RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDING TO RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_RIGHT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDING_TO_RIGHT = 16;

	/**
	 * The '<em><b>DOUBLE SWING LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE SWING LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_LEFT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_SWING_LEFT = 17;

	/**
	 * The '<em><b>DOUBLE SWING RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE SWING RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_RIGHT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_SWING_RIGHT = 18;

	/**
	 * An array of all the '<em><b>Ifc Door Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcDoorStyleOperationEnum[] VALUES_ARRAY =
		new IfcDoorStyleOperationEnum[]
		{
			NULL_LITERAL,
			SINGLE_SWING_LEFT_LITERAL,
			FOLDING_TO_LEFT_LITERAL,
			SINGLE_SWING_RIGHT_LITERAL,
			NOTDEFINED_LITERAL,
			ROLLINGUP_LITERAL,
			DOUBLE_DOOR_FOLDING_LITERAL,
			DOUBLE_DOOR_DOUBLE_SWING_LITERAL,
			DOUBLE_DOOR_SINGLE_SWING_LITERAL,
			SLIDING_TO_LEFT_LITERAL,
			DOUBLE_DOOR_SLIDING_LITERAL,
			DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_LITERAL,
			FOLDING_TO_RIGHT_LITERAL,
			REVOLVING_LITERAL,
			DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_LITERAL,
			USERDEFINED_LITERAL,
			SLIDING_TO_RIGHT_LITERAL,
			DOUBLE_SWING_LEFT_LITERAL,
			DOUBLE_SWING_RIGHT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Door Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcDoorStyleOperationEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDoorStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDoorStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case SINGLE_SWING_LEFT: return SINGLE_SWING_LEFT_LITERAL;
			case FOLDING_TO_LEFT: return FOLDING_TO_LEFT_LITERAL;
			case SINGLE_SWING_RIGHT: return SINGLE_SWING_RIGHT_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case ROLLINGUP: return ROLLINGUP_LITERAL;
			case DOUBLE_DOOR_FOLDING: return DOUBLE_DOOR_FOLDING_LITERAL;
			case DOUBLE_DOOR_DOUBLE_SWING: return DOUBLE_DOOR_DOUBLE_SWING_LITERAL;
			case DOUBLE_DOOR_SINGLE_SWING: return DOUBLE_DOOR_SINGLE_SWING_LITERAL;
			case SLIDING_TO_LEFT: return SLIDING_TO_LEFT_LITERAL;
			case DOUBLE_DOOR_SLIDING: return DOUBLE_DOOR_SLIDING_LITERAL;
			case DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT: return DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_LITERAL;
			case FOLDING_TO_RIGHT: return FOLDING_TO_RIGHT_LITERAL;
			case REVOLVING: return REVOLVING_LITERAL;
			case DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT: return DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case SLIDING_TO_RIGHT: return SLIDING_TO_RIGHT_LITERAL;
			case DOUBLE_SWING_LEFT: return DOUBLE_SWING_LEFT_LITERAL;
			case DOUBLE_SWING_RIGHT: return DOUBLE_SWING_RIGHT_LITERAL;
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
	private IfcDoorStyleOperationEnum(int value, String name, String literal)
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
	
} //IfcDoorStyleOperationEnum
