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
 * A representation of the literals of the enumeration '<em><b>Ifc Waste Terminal Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcWasteTerminalTypeEnum()
 * @model
 * @generated
 */
public enum IfcWasteTerminalTypeEnum implements Enumerator
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
	 * The '<em><b>PETROLINTERCEPTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETROLINTERCEPTOR
	 * @generated
	 * @ordered
	 */
	PETROLINTERCEPTOR_LITERAL(1, "PETROLINTERCEPTOR", "PETROLINTERCEPTOR"),

	/**
	 * The '<em><b>GULLYTRAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GULLYTRAP
	 * @generated
	 * @ordered
	 */
	GULLYTRAP_LITERAL(2, "GULLYTRAP", "GULLYTRAP"),

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
	 * The '<em><b>WASTETRAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASTETRAP
	 * @generated
	 * @ordered
	 */
	WASTETRAP_LITERAL(4, "WASTETRAP", "WASTETRAP"),

	/**
	 * The '<em><b>FLOORTRAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOORTRAP
	 * @generated
	 * @ordered
	 */
	FLOORTRAP_LITERAL(5, "FLOORTRAP", "FLOORTRAP"),

	/**
	 * The '<em><b>ROOFDRAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROOFDRAIN
	 * @generated
	 * @ordered
	 */
	ROOFDRAIN_LITERAL(6, "ROOFDRAIN", "ROOFDRAIN"),

	/**
	 * The '<em><b>GREASEINTERCEPTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREASEINTERCEPTOR
	 * @generated
	 * @ordered
	 */
	GREASEINTERCEPTOR_LITERAL(7, "GREASEINTERCEPTOR", "GREASEINTERCEPTOR"),

	/**
	 * The '<em><b>GULLYSUMP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GULLYSUMP
	 * @generated
	 * @ordered
	 */
	GULLYSUMP_LITERAL(8, "GULLYSUMP", "GULLYSUMP"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>WASTEDISPOSALUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASTEDISPOSALUNIT
	 * @generated
	 * @ordered
	 */
	WASTEDISPOSALUNIT_LITERAL(10, "WASTEDISPOSALUNIT", "WASTEDISPOSALUNIT"),

	/**
	 * The '<em><b>OILINTERCEPTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OILINTERCEPTOR
	 * @generated
	 * @ordered
	 */
	OILINTERCEPTOR_LITERAL(11, "OILINTERCEPTOR", "OILINTERCEPTOR"),

	/**
	 * The '<em><b>FLOORWASTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOORWASTE
	 * @generated
	 * @ordered
	 */
	FLOORWASTE_LITERAL(12, "FLOORWASTE", "FLOORWASTE");

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
	 * The '<em><b>PETROLINTERCEPTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PETROLINTERCEPTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETROLINTERCEPTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PETROLINTERCEPTOR = 1;

	/**
	 * The '<em><b>GULLYTRAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GULLYTRAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GULLYTRAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GULLYTRAP = 2;

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
	 * The '<em><b>WASTETRAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WASTETRAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WASTETRAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WASTETRAP = 4;

	/**
	 * The '<em><b>FLOORTRAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOORTRAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOORTRAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOORTRAP = 5;

	/**
	 * The '<em><b>ROOFDRAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROOFDRAIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROOFDRAIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROOFDRAIN = 6;

	/**
	 * The '<em><b>GREASEINTERCEPTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREASEINTERCEPTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREASEINTERCEPTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREASEINTERCEPTOR = 7;

	/**
	 * The '<em><b>GULLYSUMP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GULLYSUMP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GULLYSUMP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GULLYSUMP = 8;

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
	public static final int USERDEFINED = 9;

	/**
	 * The '<em><b>WASTEDISPOSALUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WASTEDISPOSALUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WASTEDISPOSALUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WASTEDISPOSALUNIT = 10;

	/**
	 * The '<em><b>OILINTERCEPTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OILINTERCEPTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OILINTERCEPTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OILINTERCEPTOR = 11;

	/**
	 * The '<em><b>FLOORWASTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOORWASTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOORWASTE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOORWASTE = 12;

	/**
	 * An array of all the '<em><b>Ifc Waste Terminal Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcWasteTerminalTypeEnum[] VALUES_ARRAY =
		new IfcWasteTerminalTypeEnum[]
		{
			NULL_LITERAL,
			PETROLINTERCEPTOR_LITERAL,
			GULLYTRAP_LITERAL,
			NOTDEFINED_LITERAL,
			WASTETRAP_LITERAL,
			FLOORTRAP_LITERAL,
			ROOFDRAIN_LITERAL,
			GREASEINTERCEPTOR_LITERAL,
			GULLYSUMP_LITERAL,
			USERDEFINED_LITERAL,
			WASTEDISPOSALUNIT_LITERAL,
			OILINTERCEPTOR_LITERAL,
			FLOORWASTE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Waste Terminal Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcWasteTerminalTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Waste Terminal Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWasteTerminalTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcWasteTerminalTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Waste Terminal Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWasteTerminalTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcWasteTerminalTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Waste Terminal Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWasteTerminalTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case PETROLINTERCEPTOR: return PETROLINTERCEPTOR_LITERAL;
			case GULLYTRAP: return GULLYTRAP_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case WASTETRAP: return WASTETRAP_LITERAL;
			case FLOORTRAP: return FLOORTRAP_LITERAL;
			case ROOFDRAIN: return ROOFDRAIN_LITERAL;
			case GREASEINTERCEPTOR: return GREASEINTERCEPTOR_LITERAL;
			case GULLYSUMP: return GULLYSUMP_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case WASTEDISPOSALUNIT: return WASTEDISPOSALUNIT_LITERAL;
			case OILINTERCEPTOR: return OILINTERCEPTOR_LITERAL;
			case FLOORWASTE: return FLOORWASTE_LITERAL;
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
	private IfcWasteTerminalTypeEnum(int value, String name, String literal)
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
	
} //IfcWasteTerminalTypeEnum
