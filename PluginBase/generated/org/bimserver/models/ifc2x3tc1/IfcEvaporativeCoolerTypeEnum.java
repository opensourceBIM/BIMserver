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
 * A representation of the literals of the enumeration '<em><b>Ifc Evaporative Cooler Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcEvaporativeCoolerTypeEnum()
 * @model
 * @generated
 */
public enum IfcEvaporativeCoolerTypeEnum implements Enumerator {
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
	 * The '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER(1, "DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER",
			"DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVEPACKAGEAIRCOOLER(3, "INDIRECTEVAPORATIVEPACKAGEAIRCOOLER",
			"INDIRECTEVAPORATIVEPACKAGEAIRCOOLER"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEWETCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVEWETCOIL(4, "INDIRECTEVAPORATIVEWETCOIL", "INDIRECTEVAPORATIVEWETCOIL"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER(5, "INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER",
			"INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER"),

	/**
	 * The '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTDIRECTCOMBINATION_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECTDIRECTCOMBINATION(6, "INDIRECTDIRECTCOMBINATION", "INDIRECTDIRECTCOMBINATION"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER(7, "DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER",
			"DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER(8, "DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER",
			"DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER(10, "DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER",
			"DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEAIRWASHER_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVEAIRWASHER(11, "DIRECTEVAPORATIVEAIRWASHER", "DIRECTEVAPORATIVEAIRWASHER");

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
	 * The '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_VALUE = 1;

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
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEPACKAGEAIRCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_VALUE = 3;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEWETCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVEWETCOIL_VALUE = 4;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_VALUE = 5;

	/**
	 * The '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTDIRECTCOMBINATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTDIRECTCOMBINATION_VALUE = 6;

	/**
	 * The '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_VALUE = 7;

	/**
	 * The '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_VALUE = 8;

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
	public static final int USERDEFINED_VALUE = 9;

	/**
	 * The '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_VALUE = 10;

	/**
	 * The '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEAIRWASHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVEAIRWASHER_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcEvaporativeCoolerTypeEnum[] VALUES_ARRAY = new IfcEvaporativeCoolerTypeEnum[] { NULL,
			DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER, NOTDEFINED, INDIRECTEVAPORATIVEPACKAGEAIRCOOLER,
			INDIRECTEVAPORATIVEWETCOIL, INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER, INDIRECTDIRECTCOMBINATION,
			DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER, DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER, USERDEFINED,
			DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER, DIRECTEVAPORATIVEAIRWASHER, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcEvaporativeCoolerTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEvaporativeCoolerTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEvaporativeCoolerTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_VALUE:
			return DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_VALUE:
			return INDIRECTEVAPORATIVEPACKAGEAIRCOOLER;
		case INDIRECTEVAPORATIVEWETCOIL_VALUE:
			return INDIRECTEVAPORATIVEWETCOIL;
		case INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_VALUE:
			return INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER;
		case INDIRECTDIRECTCOMBINATION_VALUE:
			return INDIRECTDIRECTCOMBINATION;
		case DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_VALUE:
			return DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER;
		case DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_VALUE:
			return DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_VALUE:
			return DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER;
		case DIRECTEVAPORATIVEAIRWASHER_VALUE:
			return DIRECTEVAPORATIVEAIRWASHER;
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
	private IfcEvaporativeCoolerTypeEnum(int value, String name, String literal) {
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

} //IfcEvaporativeCoolerTypeEnum
