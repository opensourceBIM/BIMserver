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
 * A representation of the literals of the enumeration '<em><b>Ifc Electric Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcElectricApplianceTypeEnum()
 * @model
 * @generated
 */
public enum IfcElectricApplianceTypeEnum implements Enumerator {
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
	 * The '<em><b>PHOTOCOPIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHOTOCOPIER_VALUE
	 * @generated
	 * @ordered
	 */
	PHOTOCOPIER(1, "PHOTOCOPIER", "PHOTOCOPIER"),

	/**
	 * The '<em><b>TUMBLEDRYER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUMBLEDRYER_VALUE
	 * @generated
	 * @ordered
	 */
	TUMBLEDRYER(2, "TUMBLEDRYER", "TUMBLEDRYER"),

	/**
	 * The '<em><b>MICROWAVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICROWAVE_VALUE
	 * @generated
	 * @ordered
	 */
	MICROWAVE(3, "MICROWAVE", "MICROWAVE"),

	/**
	 * The '<em><b>FREESTANDINGFAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGFAN_VALUE
	 * @generated
	 * @ordered
	 */
	FREESTANDINGFAN(4, "FREESTANDINGFAN", "FREESTANDINGFAN"),

	/**
	 * The '<em><b>VENDINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VENDINGMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	VENDINGMACHINE(5, "VENDINGMACHINE", "VENDINGMACHINE"),

	/**
	 * The '<em><b>HANDDRYER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANDDRYER_VALUE
	 * @generated
	 * @ordered
	 */
	HANDDRYER(6, "HANDDRYER", "HANDDRYER"),

	/**
	 * The '<em><b>ELECTRICCOOKER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCOOKER_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCOOKER(7, "ELECTRICCOOKER", "ELECTRICCOOKER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(8, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>FREESTANDINGWATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGWATERHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	FREESTANDINGWATERHEATER(9, "FREESTANDINGWATERHEATER", "FREESTANDINGWATERHEATER"),

	/**
	 * The '<em><b>KITCHENMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KITCHENMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	KITCHENMACHINE(10, "KITCHENMACHINE", "KITCHENMACHINE"),

	/**
	 * The '<em><b>FREESTANDINGWATERCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGWATERCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	FREESTANDINGWATERCOOLER(11, "FREESTANDINGWATERCOOLER", "FREESTANDINGWATERCOOLER"),

	/**
	 * The '<em><b>WASHINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASHINGMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	WASHINGMACHINE(12, "WASHINGMACHINE", "WASHINGMACHINE"),

	/**
	 * The '<em><b>FRIDGE FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIDGE_FREEZER_VALUE
	 * @generated
	 * @ordered
	 */
	FRIDGE_FREEZER(13, "FRIDGE_FREEZER", "FRIDGE_FREEZER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(14, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>FREESTANDINGELECTRICHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGELECTRICHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	FREESTANDINGELECTRICHEATER(15, "FREESTANDINGELECTRICHEATER", "FREESTANDINGELECTRICHEATER"),

	/**
	 * The '<em><b>FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREEZER_VALUE
	 * @generated
	 * @ordered
	 */
	FREEZER(16, "FREEZER", "FREEZER"),

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	REFRIGERATOR(17, "REFRIGERATOR", "REFRIGERATOR"),

	/**
	 * The '<em><b>DISHWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISHWASHER_VALUE
	 * @generated
	 * @ordered
	 */
	DISHWASHER(18, "DISHWASHER", "DISHWASHER");

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
	 * The '<em><b>PHOTOCOPIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHOTOCOPIER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHOTOCOPIER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHOTOCOPIER_VALUE = 1;

	/**
	 * The '<em><b>TUMBLEDRYER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUMBLEDRYER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUMBLEDRYER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUMBLEDRYER_VALUE = 2;

	/**
	 * The '<em><b>MICROWAVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MICROWAVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICROWAVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MICROWAVE_VALUE = 3;

	/**
	 * The '<em><b>FREESTANDINGFAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREESTANDINGFAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGFAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREESTANDINGFAN_VALUE = 4;

	/**
	 * The '<em><b>VENDINGMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENDINGMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENDINGMACHINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENDINGMACHINE_VALUE = 5;

	/**
	 * The '<em><b>HANDDRYER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HANDDRYER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HANDDRYER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HANDDRYER_VALUE = 6;

	/**
	 * The '<em><b>ELECTRICCOOKER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCOOKER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCOOKER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCOOKER_VALUE = 7;

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
	public static final int USERDEFINED_VALUE = 8;

	/**
	 * The '<em><b>FREESTANDINGWATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREESTANDINGWATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGWATERHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREESTANDINGWATERHEATER_VALUE = 9;

	/**
	 * The '<em><b>KITCHENMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KITCHENMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KITCHENMACHINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KITCHENMACHINE_VALUE = 10;

	/**
	 * The '<em><b>FREESTANDINGWATERCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREESTANDINGWATERCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGWATERCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREESTANDINGWATERCOOLER_VALUE = 11;

	/**
	 * The '<em><b>WASHINGMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WASHINGMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WASHINGMACHINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WASHINGMACHINE_VALUE = 12;

	/**
	 * The '<em><b>FRIDGE FREEZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRIDGE FREEZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRIDGE_FREEZER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRIDGE_FREEZER_VALUE = 13;

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
	public static final int NOTDEFINED_VALUE = 14;

	/**
	 * The '<em><b>FREESTANDINGELECTRICHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREESTANDINGELECTRICHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGELECTRICHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREESTANDINGELECTRICHEATER_VALUE = 15;

	/**
	 * The '<em><b>FREEZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREEZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREEZER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREEZER_VALUE = 16;

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFRIGERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFRIGERATOR_VALUE = 17;

	/**
	 * The '<em><b>DISHWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISHWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISHWASHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISHWASHER_VALUE = 18;

	/**
	 * An array of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElectricApplianceTypeEnum[] VALUES_ARRAY = new IfcElectricApplianceTypeEnum[] { NULL, PHOTOCOPIER, TUMBLEDRYER, MICROWAVE, FREESTANDINGFAN, VENDINGMACHINE, HANDDRYER, ELECTRICCOOKER, USERDEFINED,
			FREESTANDINGWATERHEATER, KITCHENMACHINE, FREESTANDINGWATERCOOLER, WASHINGMACHINE, FRIDGE_FREEZER, NOTDEFINED, FREESTANDINGELECTRICHEATER, FREEZER, REFRIGERATOR, DISHWASHER, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElectricApplianceTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElectricApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElectricApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case PHOTOCOPIER_VALUE:
			return PHOTOCOPIER;
		case TUMBLEDRYER_VALUE:
			return TUMBLEDRYER;
		case MICROWAVE_VALUE:
			return MICROWAVE;
		case FREESTANDINGFAN_VALUE:
			return FREESTANDINGFAN;
		case VENDINGMACHINE_VALUE:
			return VENDINGMACHINE;
		case HANDDRYER_VALUE:
			return HANDDRYER;
		case ELECTRICCOOKER_VALUE:
			return ELECTRICCOOKER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case FREESTANDINGWATERHEATER_VALUE:
			return FREESTANDINGWATERHEATER;
		case KITCHENMACHINE_VALUE:
			return KITCHENMACHINE;
		case FREESTANDINGWATERCOOLER_VALUE:
			return FREESTANDINGWATERCOOLER;
		case WASHINGMACHINE_VALUE:
			return WASHINGMACHINE;
		case FRIDGE_FREEZER_VALUE:
			return FRIDGE_FREEZER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case FREESTANDINGELECTRICHEATER_VALUE:
			return FREESTANDINGELECTRICHEATER;
		case FREEZER_VALUE:
			return FREEZER;
		case REFRIGERATOR_VALUE:
			return REFRIGERATOR;
		case DISHWASHER_VALUE:
			return DISHWASHER;
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
	private IfcElectricApplianceTypeEnum(int value, String name, String literal) {
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

} //IfcElectricApplianceTypeEnum
