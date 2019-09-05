/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Recurrence Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrenceTypeEnum()
 * @model
 * @generated
 */
public enum IfcRecurrenceTypeEnum implements Enumerator {
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NULL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>BY DAY COUNT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BY_DAY_COUNT_VALUE
	 * @generated
	 * @ordered
	 */
	BY_DAY_COUNT(1, "BY_DAY_COUNT", "BY_DAY_COUNT"),

	/**
	 * The '<em><b>WEEKLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEEKLY_VALUE
	 * @generated
	 * @ordered
	 */
	WEEKLY(2, "WEEKLY", "WEEKLY"),

	/**
	 * The '<em><b>YEARLY BY POSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEARLY_BY_POSITION_VALUE
	 * @generated
	 * @ordered
	 */
	YEARLY_BY_POSITION(3, "YEARLY_BY_POSITION", "YEARLY_BY_POSITION"),

	/**
	 * The '<em><b>DAILY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DAILY_VALUE
	 * @generated
	 * @ordered
	 */
	DAILY(4, "DAILY", "DAILY"),

	/**
	 * The '<em><b>YEARLY BY DAY OF MONTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEARLY_BY_DAY_OF_MONTH_VALUE
	 * @generated
	 * @ordered
	 */
	YEARLY_BY_DAY_OF_MONTH(5, "YEARLY_BY_DAY_OF_MONTH", "YEARLY_BY_DAY_OF_MONTH"),

	/**
	 * The '<em><b>MONTHLY BY DAY OF MONTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MONTHLY_BY_DAY_OF_MONTH_VALUE
	 * @generated
	 * @ordered
	 */
	MONTHLY_BY_DAY_OF_MONTH(6, "MONTHLY_BY_DAY_OF_MONTH", "MONTHLY_BY_DAY_OF_MONTH"),

	/**
	 * The '<em><b>BY WEEKDAY COUNT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BY_WEEKDAY_COUNT_VALUE
	 * @generated
	 * @ordered
	 */
	BY_WEEKDAY_COUNT(7, "BY_WEEKDAY_COUNT", "BY_WEEKDAY_COUNT"),

	/**
	 * The '<em><b>MONTHLY BY POSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MONTHLY_BY_POSITION_VALUE
	 * @generated
	 * @ordered
	 */
	MONTHLY_BY_POSITION(8, "MONTHLY_BY_POSITION", "MONTHLY_BY_POSITION");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>BY DAY COUNT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BY DAY COUNT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BY_DAY_COUNT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BY_DAY_COUNT_VALUE = 1;

	/**
	 * The '<em><b>WEEKLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WEEKLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEEKLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEEKLY_VALUE = 2;

	/**
	 * The '<em><b>YEARLY BY POSITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>YEARLY BY POSITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YEARLY_BY_POSITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int YEARLY_BY_POSITION_VALUE = 3;

	/**
	 * The '<em><b>DAILY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DAILY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DAILY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DAILY_VALUE = 4;

	/**
	 * The '<em><b>YEARLY BY DAY OF MONTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>YEARLY BY DAY OF MONTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YEARLY_BY_DAY_OF_MONTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int YEARLY_BY_DAY_OF_MONTH_VALUE = 5;

	/**
	 * The '<em><b>MONTHLY BY DAY OF MONTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MONTHLY BY DAY OF MONTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MONTHLY_BY_DAY_OF_MONTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MONTHLY_BY_DAY_OF_MONTH_VALUE = 6;

	/**
	 * The '<em><b>BY WEEKDAY COUNT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BY WEEKDAY COUNT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BY_WEEKDAY_COUNT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BY_WEEKDAY_COUNT_VALUE = 7;

	/**
	 * The '<em><b>MONTHLY BY POSITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MONTHLY BY POSITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MONTHLY_BY_POSITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MONTHLY_BY_POSITION_VALUE = 8;

	/**
	 * An array of all the '<em><b>Ifc Recurrence Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRecurrenceTypeEnum[] VALUES_ARRAY = new IfcRecurrenceTypeEnum[] { NULL, BY_DAY_COUNT, WEEKLY, YEARLY_BY_POSITION, DAILY, YEARLY_BY_DAY_OF_MONTH, MONTHLY_BY_DAY_OF_MONTH, BY_WEEKDAY_COUNT, MONTHLY_BY_POSITION, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Recurrence Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcRecurrenceTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Recurrence Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRecurrenceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRecurrenceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Recurrence Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRecurrenceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRecurrenceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Recurrence Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRecurrenceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case BY_DAY_COUNT_VALUE:
			return BY_DAY_COUNT;
		case WEEKLY_VALUE:
			return WEEKLY;
		case YEARLY_BY_POSITION_VALUE:
			return YEARLY_BY_POSITION;
		case DAILY_VALUE:
			return DAILY;
		case YEARLY_BY_DAY_OF_MONTH_VALUE:
			return YEARLY_BY_DAY_OF_MONTH;
		case MONTHLY_BY_DAY_OF_MONTH_VALUE:
			return MONTHLY_BY_DAY_OF_MONTH;
		case BY_WEEKDAY_COUNT_VALUE:
			return BY_WEEKDAY_COUNT;
		case MONTHLY_BY_POSITION_VALUE:
			return MONTHLY_BY_POSITION;
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
	private IfcRecurrenceTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //IfcRecurrenceTypeEnum
