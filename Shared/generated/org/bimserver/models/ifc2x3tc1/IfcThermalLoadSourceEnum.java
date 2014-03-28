/**
 * Copyright (C) 2009-2013 BIMserver.org
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Thermal Load Source Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalLoadSourceEnum()
 * @model
 * @generated
 */
public enum IfcThermalLoadSourceEnum implements Enumerator {
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
	 * The '<em><b>DRYBULBTEMPERATURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRYBULBTEMPERATURE_VALUE
	 * @generated
	 * @ordered
	 */
	DRYBULBTEMPERATURE(1, "DRYBULBTEMPERATURE", "DRYBULBTEMPERATURE"), /**
																		 * The '<em><b>VENTILATIONINDOORAIR</b></em>' literal object.
																		 * <!-- begin-user-doc -->
																		 * <!-- end-user-doc -->
																		 * @see #VENTILATIONINDOORAIR_VALUE
																		 * @generated
																		 * @ordered
																		 */
	VENTILATIONINDOORAIR(2, "VENTILATIONINDOORAIR", "VENTILATIONINDOORAIR"), /**
																				 * The '<em><b>RECIRCULATEDAIR</b></em>' literal object.
																				 * <!-- begin-user-doc -->
																				 * <!-- end-user-doc -->
																				 * @see #RECIRCULATEDAIR_VALUE
																				 * @generated
																				 * @ordered
																				 */
	RECIRCULATEDAIR(3, "RECIRCULATEDAIR", "RECIRCULATEDAIR"), /**
																 * The '<em><b>NOTDEFINED</b></em>' literal object.
																 * <!-- begin-user-doc -->
																 * <!-- end-user-doc -->
																 * @see #NOTDEFINED_VALUE
																 * @generated
																 * @ordered
																 */
	NOTDEFINED(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>RELATIVEHUMIDITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIVEHUMIDITY_VALUE
	 * @generated
	 * @ordered
	 */
	RELATIVEHUMIDITY(5, "RELATIVEHUMIDITY", "RELATIVEHUMIDITY"), /**
																	 * The '<em><b>EXHAUSTAIR</b></em>' literal object.
																	 * <!-- begin-user-doc -->
																	 * <!-- end-user-doc -->
																	 * @see #EXHAUSTAIR_VALUE
																	 * @generated
																	 * @ordered
																	 */
	EXHAUSTAIR(6, "EXHAUSTAIR", "EXHAUSTAIR"), /**
												 * The '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal object.
												 * <!-- begin-user-doc -->
												 * <!-- end-user-doc -->
												 * @see #VENTILATIONOUTSIDEAIR_VALUE
												 * @generated
												 * @ordered
												 */
	VENTILATIONOUTSIDEAIR(7, "VENTILATIONOUTSIDEAIR", "VENTILATIONOUTSIDEAIR"),

	/**
	 * The '<em><b>PEOPLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PEOPLE_VALUE
	 * @generated
	 * @ordered
	 */
	PEOPLE(8, "PEOPLE", "PEOPLE"),

	/**
	 * The '<em><b>INFILTRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFILTRATION_VALUE
	 * @generated
	 * @ordered
	 */
	INFILTRATION(9, "INFILTRATION", "INFILTRATION"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(10, "USERDEFINED", "USERDEFINED"), /**
													 * The '<em><b>EQUIPMENT</b></em>' literal object.
													 * <!-- begin-user-doc -->
													 * <!-- end-user-doc -->
													 * @see #EQUIPMENT_VALUE
													 * @generated
													 * @ordered
													 */
	EQUIPMENT(11, "EQUIPMENT", "EQUIPMENT"),

	/**
	 * The '<em><b>AIREXCHANGERATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIREXCHANGERATE_VALUE
	 * @generated
	 * @ordered
	 */
	AIREXCHANGERATE(12, "AIREXCHANGERATE", "AIREXCHANGERATE"),

	/**
	 * The '<em><b>LIGHTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTING_VALUE
	 * @generated
	 * @ordered
	 */
	LIGHTING(13, "LIGHTING", "LIGHTING");

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
	 * The '<em><b>DRYBULBTEMPERATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DRYBULBTEMPERATURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRYBULBTEMPERATURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRYBULBTEMPERATURE_VALUE = 1;

	/**
	 * The '<em><b>VENTILATIONINDOORAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENTILATIONINDOORAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONINDOORAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENTILATIONINDOORAIR_VALUE = 2;

	/**
	 * The '<em><b>RECIRCULATEDAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECIRCULATEDAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECIRCULATEDAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECIRCULATEDAIR_VALUE = 3;

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
	public static final int NOTDEFINED_VALUE = 4;

	/**
	 * The '<em><b>RELATIVEHUMIDITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RELATIVEHUMIDITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIVEHUMIDITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVEHUMIDITY_VALUE = 5;

	/**
	 * The '<em><b>EXHAUSTAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXHAUSTAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXHAUSTAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXHAUSTAIR_VALUE = 6;

	/**
	 * The '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONOUTSIDEAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENTILATIONOUTSIDEAIR_VALUE = 7;

	/**
	 * The '<em><b>PEOPLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PEOPLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PEOPLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PEOPLE_VALUE = 8;

	/**
	 * The '<em><b>INFILTRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INFILTRATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INFILTRATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INFILTRATION_VALUE = 9;

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
	public static final int USERDEFINED_VALUE = 10;

	/**
	 * The '<em><b>EQUIPMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUIPMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUIPMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUIPMENT_VALUE = 11;

	/**
	 * The '<em><b>AIREXCHANGERATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIREXCHANGERATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIREXCHANGERATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIREXCHANGERATE_VALUE = 12;

	/**
	 * The '<em><b>LIGHTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTING_VALUE = 13;

	/**
	 * An array of all the '<em><b>Ifc Thermal Load Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcThermalLoadSourceEnum[] VALUES_ARRAY = new IfcThermalLoadSourceEnum[] { NULL, DRYBULBTEMPERATURE, VENTILATIONINDOORAIR, RECIRCULATEDAIR, NOTDEFINED,
			RELATIVEHUMIDITY, EXHAUSTAIR, VENTILATIONOUTSIDEAIR, PEOPLE, INFILTRATION, USERDEFINED, EQUIPMENT, AIREXCHANGERATE, LIGHTING, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Thermal Load Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcThermalLoadSourceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcThermalLoadSourceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcThermalLoadSourceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case DRYBULBTEMPERATURE_VALUE:
			return DRYBULBTEMPERATURE;
		case VENTILATIONINDOORAIR_VALUE:
			return VENTILATIONINDOORAIR;
		case RECIRCULATEDAIR_VALUE:
			return RECIRCULATEDAIR;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case RELATIVEHUMIDITY_VALUE:
			return RELATIVEHUMIDITY;
		case EXHAUSTAIR_VALUE:
			return EXHAUSTAIR;
		case VENTILATIONOUTSIDEAIR_VALUE:
			return VENTILATIONOUTSIDEAIR;
		case PEOPLE_VALUE:
			return PEOPLE;
		case INFILTRATION_VALUE:
			return INFILTRATION;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case EQUIPMENT_VALUE:
			return EQUIPMENT;
		case AIREXCHANGERATE_VALUE:
			return AIREXCHANGERATE;
		case LIGHTING_VALUE:
			return LIGHTING;
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
	private IfcThermalLoadSourceEnum(int value, String name, String literal) {
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

} //IfcThermalLoadSourceEnum
