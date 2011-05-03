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
 * A representation of the literals of the enumeration '<em><b>Ifc Sensor Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSensorTypeEnum()
 * @model
 * @generated
 */
public enum IfcSensorTypeEnum implements Enumerator
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
	 * The '<em><b>FIRESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRESENSOR
	 * @generated
	 * @ordered
	 */
	FIRESENSOR_LITERAL(1, "FIRESENSOR", "FIRESENSOR"),

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
	 * The '<em><b>HEATSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATSENSOR
	 * @generated
	 * @ordered
	 */
	HEATSENSOR_LITERAL(3, "HEATSENSOR", "HEATSENSOR"),

	/**
	 * The '<em><b>MOVEMENTSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVEMENTSENSOR
	 * @generated
	 * @ordered
	 */
	MOVEMENTSENSOR_LITERAL(4, "MOVEMENTSENSOR", "MOVEMENTSENSOR"),

	/**
	 * The '<em><b>FLOWSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOWSENSOR
	 * @generated
	 * @ordered
	 */
	FLOWSENSOR_LITERAL(5, "FLOWSENSOR", "FLOWSENSOR"),

	/**
	 * The '<em><b>MOISTURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOISTURESENSOR
	 * @generated
	 * @ordered
	 */
	MOISTURESENSOR_LITERAL(6, "MOISTURESENSOR", "MOISTURESENSOR"),

	/**
	 * The '<em><b>LIGHTSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTSENSOR
	 * @generated
	 * @ordered
	 */
	LIGHTSENSOR_LITERAL(7, "LIGHTSENSOR", "LIGHTSENSOR"),

	/**
	 * The '<em><b>SMOKESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMOKESENSOR
	 * @generated
	 * @ordered
	 */
	SMOKESENSOR_LITERAL(8, "SMOKESENSOR", "SMOKESENSOR"),

	/**
	 * The '<em><b>GASSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASSENSOR
	 * @generated
	 * @ordered
	 */
	GASSENSOR_LITERAL(9, "GASSENSOR", "GASSENSOR"),

	/**
	 * The '<em><b>TEMPERATURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURESENSOR
	 * @generated
	 * @ordered
	 */
	TEMPERATURESENSOR_LITERAL(10, "TEMPERATURESENSOR", "TEMPERATURESENSOR"),

	/**
	 * The '<em><b>PRESSURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSURESENSOR
	 * @generated
	 * @ordered
	 */
	PRESSURESENSOR_LITERAL(11, "PRESSURESENSOR", "PRESSURESENSOR"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(12, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>HUMIDITYSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUMIDITYSENSOR
	 * @generated
	 * @ordered
	 */
	HUMIDITYSENSOR_LITERAL(13, "HUMIDITYSENSOR", "HUMIDITYSENSOR"),

	/**
	 * The '<em><b>CO2SENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CO2SENSOR
	 * @generated
	 * @ordered
	 */
	CO2SENSOR_LITERAL(14, "CO2SENSOR", "CO2SENSOR"),

	/**
	 * The '<em><b>SOUNDSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUNDSENSOR
	 * @generated
	 * @ordered
	 */
	SOUNDSENSOR_LITERAL(15, "SOUNDSENSOR", "SOUNDSENSOR");

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
	 * The '<em><b>FIRESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRESENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRESENSOR = 1;

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
	 * The '<em><b>HEATSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATSENSOR = 3;

	/**
	 * The '<em><b>MOVEMENTSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOVEMENTSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVEMENTSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVEMENTSENSOR = 4;

	/**
	 * The '<em><b>FLOWSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOWSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOWSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOWSENSOR = 5;

	/**
	 * The '<em><b>MOISTURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOISTURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOISTURESENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOISTURESENSOR = 6;

	/**
	 * The '<em><b>LIGHTSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTSENSOR = 7;

	/**
	 * The '<em><b>SMOKESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMOKESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMOKESENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMOKESENSOR = 8;

	/**
	 * The '<em><b>GASSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASSENSOR = 9;

	/**
	 * The '<em><b>TEMPERATURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPERATURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURESENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPERATURESENSOR = 10;

	/**
	 * The '<em><b>PRESSURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSURESENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSURESENSOR = 11;

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
	public static final int USERDEFINED = 12;

	/**
	 * The '<em><b>HUMIDITYSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUMIDITYSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUMIDITYSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUMIDITYSENSOR = 13;

	/**
	 * The '<em><b>CO2SENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CO2SENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CO2SENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CO2SENSOR = 14;

	/**
	 * The '<em><b>SOUNDSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOUNDSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOUNDSENSOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOUNDSENSOR = 15;

	/**
	 * An array of all the '<em><b>Ifc Sensor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSensorTypeEnum[] VALUES_ARRAY =
		new IfcSensorTypeEnum[]
		{
			NULL_LITERAL,
			FIRESENSOR_LITERAL,
			NOTDEFINED_LITERAL,
			HEATSENSOR_LITERAL,
			MOVEMENTSENSOR_LITERAL,
			FLOWSENSOR_LITERAL,
			MOISTURESENSOR_LITERAL,
			LIGHTSENSOR_LITERAL,
			SMOKESENSOR_LITERAL,
			GASSENSOR_LITERAL,
			TEMPERATURESENSOR_LITERAL,
			PRESSURESENSOR_LITERAL,
			USERDEFINED_LITERAL,
			HUMIDITYSENSOR_LITERAL,
			CO2SENSOR_LITERAL,
			SOUNDSENSOR_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Sensor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSensorTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Sensor Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSensorTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSensorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sensor Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSensorTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSensorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sensor Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSensorTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case FIRESENSOR: return FIRESENSOR_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case HEATSENSOR: return HEATSENSOR_LITERAL;
			case MOVEMENTSENSOR: return MOVEMENTSENSOR_LITERAL;
			case FLOWSENSOR: return FLOWSENSOR_LITERAL;
			case MOISTURESENSOR: return MOISTURESENSOR_LITERAL;
			case LIGHTSENSOR: return LIGHTSENSOR_LITERAL;
			case SMOKESENSOR: return SMOKESENSOR_LITERAL;
			case GASSENSOR: return GASSENSOR_LITERAL;
			case TEMPERATURESENSOR: return TEMPERATURESENSOR_LITERAL;
			case PRESSURESENSOR: return PRESSURESENSOR_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case HUMIDITYSENSOR: return HUMIDITYSENSOR_LITERAL;
			case CO2SENSOR: return CO2SENSOR_LITERAL;
			case SOUNDSENSOR: return SOUNDSENSOR_LITERAL;
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
	private IfcSensorTypeEnum(int value, String name, String literal)
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
	
} //IfcSensorTypeEnum
