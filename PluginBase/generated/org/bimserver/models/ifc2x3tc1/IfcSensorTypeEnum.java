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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the literals of the enumeration '<em><b>Ifc Sensor Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSensorTypeEnum()
 * @model
 * @generated
 */
public enum IfcSensorTypeEnum implements Enumerator {
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
	 * The '<em><b>HUMIDITYSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUMIDITYSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	HUMIDITYSENSOR(1, "HUMIDITYSENSOR", "HUMIDITYSENSOR"),

	/**
	 * The '<em><b>PRESSURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSURESENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	PRESSURESENSOR(2, "PRESSURESENSOR", "PRESSURESENSOR"),

	/**
	 * The '<em><b>FIRESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRESENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	FIRESENSOR(3, "FIRESENSOR", "FIRESENSOR"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(4, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>GASSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	GASSENSOR(5, "GASSENSOR", "GASSENSOR"),

	/**
	 * The '<em><b>HEATSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	HEATSENSOR(6, "HEATSENSOR", "HEATSENSOR"),

	/**
	 * The '<em><b>CO2SENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CO2SENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	CO2SENSOR(7, "CO2SENSOR", "CO2SENSOR"),

	/**
	 * The '<em><b>MOVEMENTSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVEMENTSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	MOVEMENTSENSOR(8, "MOVEMENTSENSOR", "MOVEMENTSENSOR"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(9, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>LIGHTSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	LIGHTSENSOR(10, "LIGHTSENSOR", "LIGHTSENSOR"),

	/**
	 * The '<em><b>SOUNDSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUNDSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	SOUNDSENSOR(11, "SOUNDSENSOR", "SOUNDSENSOR"),

	/**
	 * The '<em><b>TEMPERATURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURESENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPERATURESENSOR(12, "TEMPERATURESENSOR", "TEMPERATURESENSOR"),

	/**
	 * The '<em><b>FLOWSENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOWSENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	FLOWSENSOR(13, "FLOWSENSOR", "FLOWSENSOR"),

	/**
	 * The '<em><b>MOISTURESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOISTURESENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	MOISTURESENSOR(14, "MOISTURESENSOR", "MOISTURESENSOR"),

	/**
	 * The '<em><b>SMOKESENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMOKESENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	SMOKESENSOR(15, "SMOKESENSOR", "SMOKESENSOR");

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
	 * The '<em><b>HUMIDITYSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUMIDITYSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUMIDITYSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUMIDITYSENSOR_VALUE = 1;

	/**
	 * The '<em><b>PRESSURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSURESENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSURESENSOR_VALUE = 2;

	/**
	 * The '<em><b>FIRESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRESENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRESENSOR_VALUE = 3;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 4;

	/**
	 * The '<em><b>GASSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASSENSOR_VALUE = 5;

	/**
	 * The '<em><b>HEATSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATSENSOR_VALUE = 6;

	/**
	 * The '<em><b>CO2SENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CO2SENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CO2SENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CO2SENSOR_VALUE = 7;

	/**
	 * The '<em><b>MOVEMENTSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOVEMENTSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVEMENTSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVEMENTSENSOR_VALUE = 8;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 9;

	/**
	 * The '<em><b>LIGHTSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTSENSOR_VALUE = 10;

	/**
	 * The '<em><b>SOUNDSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOUNDSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOUNDSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOUNDSENSOR_VALUE = 11;

	/**
	 * The '<em><b>TEMPERATURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPERATURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURESENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPERATURESENSOR_VALUE = 12;

	/**
	 * The '<em><b>FLOWSENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOWSENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOWSENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOWSENSOR_VALUE = 13;

	/**
	 * The '<em><b>MOISTURESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOISTURESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOISTURESENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOISTURESENSOR_VALUE = 14;

	/**
	 * The '<em><b>SMOKESENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMOKESENSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMOKESENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMOKESENSOR_VALUE = 15;

	/**
	 * An array of all the '<em><b>Ifc Sensor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSensorTypeEnum[] VALUES_ARRAY = new IfcSensorTypeEnum[] { NULL, HUMIDITYSENSOR,
			PRESSURESENSOR, FIRESENSOR, USERDEFINED, GASSENSOR, HEATSENSOR, CO2SENSOR, MOVEMENTSENSOR, NOTDEFINED,
			LIGHTSENSOR, SOUNDSENSOR, TEMPERATURESENSOR, FLOWSENSOR, MOISTURESENSOR, SMOKESENSOR, };

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
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSensorTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSensorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sensor Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSensorTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSensorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Sensor Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSensorTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case HUMIDITYSENSOR_VALUE:
			return HUMIDITYSENSOR;
		case PRESSURESENSOR_VALUE:
			return PRESSURESENSOR;
		case FIRESENSOR_VALUE:
			return FIRESENSOR;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case GASSENSOR_VALUE:
			return GASSENSOR;
		case HEATSENSOR_VALUE:
			return HEATSENSOR;
		case CO2SENSOR_VALUE:
			return CO2SENSOR;
		case MOVEMENTSENSOR_VALUE:
			return MOVEMENTSENSOR;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case LIGHTSENSOR_VALUE:
			return LIGHTSENSOR;
		case SOUNDSENSOR_VALUE:
			return SOUNDSENSOR;
		case TEMPERATURESENSOR_VALUE:
			return TEMPERATURESENSOR;
		case FLOWSENSOR_VALUE:
			return FLOWSENSOR;
		case MOISTURESENSOR_VALUE:
			return MOISTURESENSOR;
		case SMOKESENSOR_VALUE:
			return SMOKESENSOR;
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
	private IfcSensorTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

} //IfcSensorTypeEnum
