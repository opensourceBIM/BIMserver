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
 * A representation of the literals of the enumeration '<em><b>Ifc Cost Schedule Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCostScheduleTypeEnum()
 * @model
 * @generated
 */
public enum IfcCostScheduleTypeEnum implements Enumerator
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
	 * The '<em><b>TENDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TENDER
	 * @generated
	 * @ordered
	 */
	TENDER_LITERAL(1, "TENDER", "TENDER"),

	/**
	 * The '<em><b>BUDGET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUDGET
	 * @generated
	 * @ordered
	 */
	BUDGET_LITERAL(2, "BUDGET", "BUDGET"),

	/**
	 * The '<em><b>COSTPLAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSTPLAN
	 * @generated
	 * @ordered
	 */
	COSTPLAN_LITERAL(3, "COSTPLAN", "COSTPLAN"),

	/**
	 * The '<em><b>PRICEDBILLOFQUANTITIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRICEDBILLOFQUANTITIES
	 * @generated
	 * @ordered
	 */
	PRICEDBILLOFQUANTITIES_LITERAL(4, "PRICEDBILLOFQUANTITIES", "PRICEDBILLOFQUANTITIES"),

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
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(6, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>UNPRICEDBILLOFQUANTITIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNPRICEDBILLOFQUANTITIES
	 * @generated
	 * @ordered
	 */
	UNPRICEDBILLOFQUANTITIES_LITERAL(7, "UNPRICEDBILLOFQUANTITIES", "UNPRICEDBILLOFQUANTITIES"),

	/**
	 * The '<em><b>SCHEDULEOFRATES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEDULEOFRATES
	 * @generated
	 * @ordered
	 */
	SCHEDULEOFRATES_LITERAL(8, "SCHEDULEOFRATES", "SCHEDULEOFRATES"),

	/**
	 * The '<em><b>ESTIMATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ESTIMATE
	 * @generated
	 * @ordered
	 */
	ESTIMATE_LITERAL(9, "ESTIMATE", "ESTIMATE");

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
	 * The '<em><b>TENDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TENDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TENDER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TENDER = 1;

	/**
	 * The '<em><b>BUDGET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUDGET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUDGET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUDGET = 2;

	/**
	 * The '<em><b>COSTPLAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COSTPLAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COSTPLAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COSTPLAN = 3;

	/**
	 * The '<em><b>PRICEDBILLOFQUANTITIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRICEDBILLOFQUANTITIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRICEDBILLOFQUANTITIES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRICEDBILLOFQUANTITIES = 4;

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
	 * The '<em><b>UNPRICEDBILLOFQUANTITIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNPRICEDBILLOFQUANTITIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNPRICEDBILLOFQUANTITIES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNPRICEDBILLOFQUANTITIES = 7;

	/**
	 * The '<em><b>SCHEDULEOFRATES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCHEDULEOFRATES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCHEDULEOFRATES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULEOFRATES = 8;

	/**
	 * The '<em><b>ESTIMATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ESTIMATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ESTIMATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ESTIMATE = 9;

	/**
	 * An array of all the '<em><b>Ifc Cost Schedule Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCostScheduleTypeEnum[] VALUES_ARRAY =
		new IfcCostScheduleTypeEnum[]
		{
			NULL_LITERAL,
			TENDER_LITERAL,
			BUDGET_LITERAL,
			COSTPLAN_LITERAL,
			PRICEDBILLOFQUANTITIES_LITERAL,
			NOTDEFINED_LITERAL,
			USERDEFINED_LITERAL,
			UNPRICEDBILLOFQUANTITIES_LITERAL,
			SCHEDULEOFRATES_LITERAL,
			ESTIMATE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Cost Schedule Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCostScheduleTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Cost Schedule Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCostScheduleTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCostScheduleTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Cost Schedule Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCostScheduleTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCostScheduleTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Cost Schedule Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCostScheduleTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case TENDER: return TENDER_LITERAL;
			case BUDGET: return BUDGET_LITERAL;
			case COSTPLAN: return COSTPLAN_LITERAL;
			case PRICEDBILLOFQUANTITIES: return PRICEDBILLOFQUANTITIES_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case UNPRICEDBILLOFQUANTITIES: return UNPRICEDBILLOFQUANTITIES_LITERAL;
			case SCHEDULEOFRATES: return SCHEDULEOFRATES_LITERAL;
			case ESTIMATE: return ESTIMATE_LITERAL;
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
	private IfcCostScheduleTypeEnum(int value, String name, String literal)
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
	
} //IfcCostScheduleTypeEnum
