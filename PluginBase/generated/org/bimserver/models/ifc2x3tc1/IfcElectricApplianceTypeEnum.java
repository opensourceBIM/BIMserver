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
 * A representation of the literals of the enumeration '<em><b>Ifc Electric Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcElectricApplianceTypeEnum()
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
	 * The '<em><b>TV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TV_VALUE
	 * @generated
	 * @ordered
	 */
	TV(1, "TV", "TV"),

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
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(3, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>WASHINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASHINGMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	WASHINGMACHINE(4, "WASHINGMACHINE", "WASHINGMACHINE"),

	/**
	 * The '<em><b>FRIDGE FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIDGE_FREEZER_VALUE
	 * @generated
	 * @ordered
	 */
	FRIDGE_FREEZER(5, "FRIDGE_FREEZER", "FRIDGE_FREEZER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(6, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREEZER_VALUE
	 * @generated
	 * @ordered
	 */
	FREEZER(7, "FREEZER", "FREEZER"),

	/**
	 * The '<em><b>ELECTRICHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICHEATER(8, "ELECTRICHEATER", "ELECTRICHEATER"),

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	REFRIGERATOR(9, "REFRIGERATOR", "REFRIGERATOR"),

	/**
	 * The '<em><b>DISHWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISHWASHER_VALUE
	 * @generated
	 * @ordered
	 */
	DISHWASHER(10, "DISHWASHER", "DISHWASHER"),

	/**
	 * The '<em><b>WATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	WATERHEATER(11, "WATERHEATER", "WATERHEATER"),

	/**
	 * The '<em><b>TELEPHONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELEPHONE_VALUE
	 * @generated
	 * @ordered
	 */
	TELEPHONE(12, "TELEPHONE", "TELEPHONE"),

	/**
	 * The '<em><b>RADIANTHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIANTHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	RADIANTHEATER(13, "RADIANTHEATER", "RADIANTHEATER"),

	/**
	 * The '<em><b>PHOTOCOPIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHOTOCOPIER_VALUE
	 * @generated
	 * @ordered
	 */
	PHOTOCOPIER(14, "PHOTOCOPIER", "PHOTOCOPIER"),

	/**
	 * The '<em><b>MICROWAVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICROWAVE_VALUE
	 * @generated
	 * @ordered
	 */
	MICROWAVE(15, "MICROWAVE", "MICROWAVE"),

	/**
	 * The '<em><b>FREESTANDINGFAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGFAN_VALUE
	 * @generated
	 * @ordered
	 */
	FREESTANDINGFAN(16, "FREESTANDINGFAN", "FREESTANDINGFAN"),

	/**
	 * The '<em><b>VENDINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VENDINGMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	VENDINGMACHINE(17, "VENDINGMACHINE", "VENDINGMACHINE"),

	/**
	 * The '<em><b>HANDDRYER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANDDRYER_VALUE
	 * @generated
	 * @ordered
	 */
	HANDDRYER(18, "HANDDRYER", "HANDDRYER"),

	/**
	 * The '<em><b>INDIRECTWATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTWATERHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECTWATERHEATER(19, "INDIRECTWATERHEATER", "INDIRECTWATERHEATER"),

	/**
	 * The '<em><b>ELECTRICCOOKER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCOOKER_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCOOKER(20, "ELECTRICCOOKER", "ELECTRICCOOKER"),

	/**
	 * The '<em><b>SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	SCANNER(21, "SCANNER", "SCANNER"),

	/**
	 * The '<em><b>DIRECTWATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTWATERHEATER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTWATERHEATER(22, "DIRECTWATERHEATER", "DIRECTWATERHEATER"),

	/**
	 * The '<em><b>PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	PRINTER(23, "PRINTER", "PRINTER"),

	/**
	 * The '<em><b>COMPUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTER(24, "COMPUTER", "COMPUTER"),

	/**
	 * The '<em><b>WATERCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	WATERCOOLER(25, "WATERCOOLER", "WATERCOOLER"),

	/**
	 * The '<em><b>FACSIMILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACSIMILE_VALUE
	 * @generated
	 * @ordered
	 */
	FACSIMILE(26, "FACSIMILE", "FACSIMILE");

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
	 * The '<em><b>TV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TV_VALUE = 1;

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
	public static final int USERDEFINED_VALUE = 3;

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
	public static final int WASHINGMACHINE_VALUE = 4;

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
	public static final int FRIDGE_FREEZER_VALUE = 5;

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
	public static final int NOTDEFINED_VALUE = 6;

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
	public static final int FREEZER_VALUE = 7;

	/**
	 * The '<em><b>ELECTRICHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICHEATER_VALUE = 8;

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
	public static final int REFRIGERATOR_VALUE = 9;

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
	public static final int DISHWASHER_VALUE = 10;

	/**
	 * The '<em><b>WATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERHEATER_VALUE = 11;

	/**
	 * The '<em><b>TELEPHONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TELEPHONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TELEPHONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TELEPHONE_VALUE = 12;

	/**
	 * The '<em><b>RADIANTHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIANTHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIANTHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIANTHEATER_VALUE = 13;

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
	public static final int PHOTOCOPIER_VALUE = 14;

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
	public static final int MICROWAVE_VALUE = 15;

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
	public static final int FREESTANDINGFAN_VALUE = 16;

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
	public static final int VENDINGMACHINE_VALUE = 17;

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
	public static final int HANDDRYER_VALUE = 18;

	/**
	 * The '<em><b>INDIRECTWATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTWATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTWATERHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTWATERHEATER_VALUE = 19;

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
	public static final int ELECTRICCOOKER_VALUE = 20;

	/**
	 * The '<em><b>SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCANNER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCANNER_VALUE = 21;

	/**
	 * The '<em><b>DIRECTWATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTWATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTWATERHEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTWATERHEATER_VALUE = 22;

	/**
	 * The '<em><b>PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRINTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRINTER_VALUE = 23;

	/**
	 * The '<em><b>COMPUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPUTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTER_VALUE = 24;

	/**
	 * The '<em><b>WATERCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLER_VALUE = 25;

	/**
	 * The '<em><b>FACSIMILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FACSIMILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACSIMILE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FACSIMILE_VALUE = 26;

	/**
	 * An array of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElectricApplianceTypeEnum[] VALUES_ARRAY = new IfcElectricApplianceTypeEnum[] { NULL, TV,
			TUMBLEDRYER, USERDEFINED, WASHINGMACHINE, FRIDGE_FREEZER, NOTDEFINED, FREEZER, ELECTRICHEATER, REFRIGERATOR,
			DISHWASHER, WATERHEATER, TELEPHONE, RADIANTHEATER, PHOTOCOPIER, MICROWAVE, FREESTANDINGFAN, VENDINGMACHINE,
			HANDDRYER, INDIRECTWATERHEATER, ELECTRICCOOKER, SCANNER, DIRECTWATERHEATER, PRINTER, COMPUTER, WATERCOOLER,
			FACSIMILE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElectricApplianceTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

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
		case TV_VALUE:
			return TV;
		case TUMBLEDRYER_VALUE:
			return TUMBLEDRYER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case WASHINGMACHINE_VALUE:
			return WASHINGMACHINE;
		case FRIDGE_FREEZER_VALUE:
			return FRIDGE_FREEZER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case FREEZER_VALUE:
			return FREEZER;
		case ELECTRICHEATER_VALUE:
			return ELECTRICHEATER;
		case REFRIGERATOR_VALUE:
			return REFRIGERATOR;
		case DISHWASHER_VALUE:
			return DISHWASHER;
		case WATERHEATER_VALUE:
			return WATERHEATER;
		case TELEPHONE_VALUE:
			return TELEPHONE;
		case RADIANTHEATER_VALUE:
			return RADIANTHEATER;
		case PHOTOCOPIER_VALUE:
			return PHOTOCOPIER;
		case MICROWAVE_VALUE:
			return MICROWAVE;
		case FREESTANDINGFAN_VALUE:
			return FREESTANDINGFAN;
		case VENDINGMACHINE_VALUE:
			return VENDINGMACHINE;
		case HANDDRYER_VALUE:
			return HANDDRYER;
		case INDIRECTWATERHEATER_VALUE:
			return INDIRECTWATERHEATER;
		case ELECTRICCOOKER_VALUE:
			return ELECTRICCOOKER;
		case SCANNER_VALUE:
			return SCANNER;
		case DIRECTWATERHEATER_VALUE:
			return DIRECTWATERHEATER;
		case PRINTER_VALUE:
			return PRINTER;
		case COMPUTER_VALUE:
			return COMPUTER;
		case WATERCOOLER_VALUE:
			return WATERCOOLER;
		case FACSIMILE_VALUE:
			return FACSIMILE;
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

} //IfcElectricApplianceTypeEnum
