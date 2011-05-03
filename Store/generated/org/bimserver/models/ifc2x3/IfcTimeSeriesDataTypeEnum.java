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
 * A representation of the literals of the enumeration '<em><b>Ifc Time Series Data Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesDataTypeEnum()
 * @model
 * @generated
 */
public enum IfcTimeSeriesDataTypeEnum implements Enumerator
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
	 * The '<em><b>CONTINUOUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS
	 * @generated
	 * @ordered
	 */
	CONTINUOUS_LITERAL(2, "CONTINUOUS", "CONTINUOUS"),

	/**
	 * The '<em><b>DISCRETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCRETE
	 * @generated
	 * @ordered
	 */
	DISCRETE_LITERAL(3, "DISCRETE", "DISCRETE"),

	/**
	 * The '<em><b>DISCRETEBINARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCRETEBINARY
	 * @generated
	 * @ordered
	 */
	DISCRETEBINARY_LITERAL(4, "DISCRETEBINARY", "DISCRETEBINARY"),

	/**
	 * The '<em><b>PIECEWISEBINARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIECEWISEBINARY
	 * @generated
	 * @ordered
	 */
	PIECEWISEBINARY_LITERAL(5, "PIECEWISEBINARY", "PIECEWISEBINARY"),

	/**
	 * The '<em><b>PIECEWISECONSTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIECEWISECONSTANT
	 * @generated
	 * @ordered
	 */
	PIECEWISECONSTANT_LITERAL(6, "PIECEWISECONSTANT", "PIECEWISECONSTANT"),

	/**
	 * The '<em><b>PIECEWISECONTINUOUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIECEWISECONTINUOUS
	 * @generated
	 * @ordered
	 */
	PIECEWISECONTINUOUS_LITERAL(7, "PIECEWISECONTINUOUS", "PIECEWISECONTINUOUS");

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
	 * The '<em><b>CONTINUOUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTINUOUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTINUOUS = 2;

	/**
	 * The '<em><b>DISCRETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISCRETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISCRETE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISCRETE = 3;

	/**
	 * The '<em><b>DISCRETEBINARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISCRETEBINARY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISCRETEBINARY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISCRETEBINARY = 4;

	/**
	 * The '<em><b>PIECEWISEBINARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIECEWISEBINARY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIECEWISEBINARY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIECEWISEBINARY = 5;

	/**
	 * The '<em><b>PIECEWISECONSTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIECEWISECONSTANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIECEWISECONSTANT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIECEWISECONSTANT = 6;

	/**
	 * The '<em><b>PIECEWISECONTINUOUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIECEWISECONTINUOUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIECEWISECONTINUOUS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIECEWISECONTINUOUS = 7;

	/**
	 * An array of all the '<em><b>Ifc Time Series Data Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcTimeSeriesDataTypeEnum[] VALUES_ARRAY =
		new IfcTimeSeriesDataTypeEnum[]
		{
			NULL_LITERAL,
			NOTDEFINED_LITERAL,
			CONTINUOUS_LITERAL,
			DISCRETE_LITERAL,
			DISCRETEBINARY_LITERAL,
			PIECEWISEBINARY_LITERAL,
			PIECEWISECONSTANT_LITERAL,
			PIECEWISECONTINUOUS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Time Series Data Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcTimeSeriesDataTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Time Series Data Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcTimeSeriesDataTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcTimeSeriesDataTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Time Series Data Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcTimeSeriesDataTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcTimeSeriesDataTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Time Series Data Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcTimeSeriesDataTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case CONTINUOUS: return CONTINUOUS_LITERAL;
			case DISCRETE: return DISCRETE_LITERAL;
			case DISCRETEBINARY: return DISCRETEBINARY_LITERAL;
			case PIECEWISEBINARY: return PIECEWISEBINARY_LITERAL;
			case PIECEWISECONSTANT: return PIECEWISECONSTANT_LITERAL;
			case PIECEWISECONTINUOUS: return PIECEWISECONTINUOUS_LITERAL;
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
	private IfcTimeSeriesDataTypeEnum(int value, String name, String literal)
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
	
} //IfcTimeSeriesDataTypeEnum
