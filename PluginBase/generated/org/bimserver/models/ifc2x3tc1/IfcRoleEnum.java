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
 * A representation of the literals of the enumeration '<em><b>Ifc Role Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRoleEnum()
 * @model
 * @generated
 */
public enum IfcRoleEnum implements Enumerator {
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
	 * The '<em><b>CONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTIONMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTRUCTIONMANAGER(1, "CONSTRUCTIONMANAGER", "CONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>COSTENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSTENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	COSTENGINEER(2, "COSTENGINEER", "COSTENGINEER"),

	/**
	 * The '<em><b>CONSULTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSULTANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSULTANT(3, "CONSULTANT", "CONSULTANT"),

	/**
	 * The '<em><b>BUILDINGOWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOWNER_VALUE
	 * @generated
	 * @ordered
	 */
	BUILDINGOWNER(4, "BUILDINGOWNER", "BUILDINGOWNER"),

	/**
	 * The '<em><b>COMISSIONINGENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMISSIONINGENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	COMISSIONINGENGINEER(5, "COMISSIONINGENGINEER", "COMISSIONINGENGINEER"),

	/**
	 * The '<em><b>ENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	ENGINEER(6, "ENGINEER", "ENGINEER"),

	/**
	 * The '<em><b>CONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRACTOR(7, "CONTRACTOR", "CONTRACTOR"),

	/**
	 * The '<em><b>ELECTRICALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICALENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICALENGINEER(8, "ELECTRICALENGINEER", "ELECTRICALENGINEER"),

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
	 * The '<em><b>MANUFACTURER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURER_VALUE
	 * @generated
	 * @ordered
	 */
	MANUFACTURER(10, "MANUFACTURER", "MANUFACTURER"),

	/**
	 * The '<em><b>SUPPLIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPPLIER_VALUE
	 * @generated
	 * @ordered
	 */
	SUPPLIER(11, "SUPPLIER", "SUPPLIER"),

	/**
	 * The '<em><b>STRUCTURALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURALENGINEER(12, "STRUCTURALENGINEER", "STRUCTURALENGINEER"),

	/**
	 * The '<em><b>CLIENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLIENT_VALUE
	 * @generated
	 * @ordered
	 */
	CLIENT(13, "CLIENT", "CLIENT"),

	/**
	 * The '<em><b>OWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNER_VALUE
	 * @generated
	 * @ordered
	 */
	OWNER(14, "OWNER", "OWNER"),

	/**
	 * The '<em><b>RESELLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESELLER_VALUE
	 * @generated
	 * @ordered
	 */
	RESELLER(15, "RESELLER", "RESELLER"),

	/**
	 * The '<em><b>CIVILENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIVILENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	CIVILENGINEER(16, "CIVILENGINEER", "CIVILENGINEER"),

	/**
	 * The '<em><b>BUILDINGOPERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOPERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	BUILDINGOPERATOR(17, "BUILDINGOPERATOR", "BUILDINGOPERATOR"),

	/**
	 * The '<em><b>PROJECTMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECTMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	PROJECTMANAGER(18, "PROJECTMANAGER", "PROJECTMANAGER"),

	/**
	 * The '<em><b>MECHANICALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICALENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	MECHANICALENGINEER(19, "MECHANICALENGINEER", "MECHANICALENGINEER"),

	/**
	 * The '<em><b>FACILITIESMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACILITIESMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	FACILITIESMANAGER(20, "FACILITIESMANAGER", "FACILITIESMANAGER"),

	/**
	 * The '<em><b>SUBCONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBCONTRACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	SUBCONTRACTOR(21, "SUBCONTRACTOR", "SUBCONTRACTOR"),

	/**
	 * The '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELDCONSTRUCTIONMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	FIELDCONSTRUCTIONMANAGER(22, "FIELDCONSTRUCTIONMANAGER", "FIELDCONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>ARCHITECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHITECT_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHITECT(23, "ARCHITECT", "ARCHITECT");

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
	 * The '<em><b>CONSTRUCTIONMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTRUCTIONMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTIONMANAGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRUCTIONMANAGER_VALUE = 1;

	/**
	 * The '<em><b>COSTENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COSTENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COSTENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COSTENGINEER_VALUE = 2;

	/**
	 * The '<em><b>CONSULTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSULTANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSULTANT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSULTANT_VALUE = 3;

	/**
	 * The '<em><b>BUILDINGOWNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILDINGOWNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOWNER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUILDINGOWNER_VALUE = 4;

	/**
	 * The '<em><b>COMISSIONINGENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMISSIONINGENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMISSIONINGENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMISSIONINGENGINEER_VALUE = 5;

	/**
	 * The '<em><b>ENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENGINEER_VALUE = 6;

	/**
	 * The '<em><b>CONTRACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTRACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTRACTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTRACTOR_VALUE = 7;

	/**
	 * The '<em><b>ELECTRICALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICALENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICALENGINEER_VALUE = 8;

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
	 * The '<em><b>MANUFACTURER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANUFACTURER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANUFACTURER_VALUE = 10;

	/**
	 * The '<em><b>SUPPLIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUPPLIER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUPPLIER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPPLIER_VALUE = 11;

	/**
	 * The '<em><b>STRUCTURALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRUCTURALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURALENGINEER_VALUE = 12;

	/**
	 * The '<em><b>CLIENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLIENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT_VALUE = 13;

	/**
	 * The '<em><b>OWNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OWNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OWNER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OWNER_VALUE = 14;

	/**
	 * The '<em><b>RESELLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESELLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESELLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESELLER_VALUE = 15;

	/**
	 * The '<em><b>CIVILENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CIVILENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIVILENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIVILENGINEER_VALUE = 16;

	/**
	 * The '<em><b>BUILDINGOPERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILDINGOPERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOPERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUILDINGOPERATOR_VALUE = 17;

	/**
	 * The '<em><b>PROJECTMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROJECTMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECTMANAGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROJECTMANAGER_VALUE = 18;

	/**
	 * The '<em><b>MECHANICALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MECHANICALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MECHANICALENGINEER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MECHANICALENGINEER_VALUE = 19;

	/**
	 * The '<em><b>FACILITIESMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FACILITIESMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACILITIESMANAGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FACILITIESMANAGER_VALUE = 20;

	/**
	 * The '<em><b>SUBCONTRACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBCONTRACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBCONTRACTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBCONTRACTOR_VALUE = 21;

	/**
	 * The '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIELDCONSTRUCTIONMANAGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIELDCONSTRUCTIONMANAGER_VALUE = 22;

	/**
	 * The '<em><b>ARCHITECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARCHITECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARCHITECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCHITECT_VALUE = 23;

	/**
	 * An array of all the '<em><b>Ifc Role Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoleEnum[] VALUES_ARRAY = new IfcRoleEnum[] { NULL, CONSTRUCTIONMANAGER, COSTENGINEER,
			CONSULTANT, BUILDINGOWNER, COMISSIONINGENGINEER, ENGINEER, CONTRACTOR, ELECTRICALENGINEER, USERDEFINED,
			MANUFACTURER, SUPPLIER, STRUCTURALENGINEER, CLIENT, OWNER, RESELLER, CIVILENGINEER, BUILDINGOPERATOR,
			PROJECTMANAGER, MECHANICALENGINEER, FACILITIESMANAGER, SUBCONTRACTOR, FIELDCONSTRUCTIONMANAGER,
			ARCHITECT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Role Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcRoleEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Role Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoleEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoleEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Role Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoleEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoleEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Role Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoleEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case CONSTRUCTIONMANAGER_VALUE:
			return CONSTRUCTIONMANAGER;
		case COSTENGINEER_VALUE:
			return COSTENGINEER;
		case CONSULTANT_VALUE:
			return CONSULTANT;
		case BUILDINGOWNER_VALUE:
			return BUILDINGOWNER;
		case COMISSIONINGENGINEER_VALUE:
			return COMISSIONINGENGINEER;
		case ENGINEER_VALUE:
			return ENGINEER;
		case CONTRACTOR_VALUE:
			return CONTRACTOR;
		case ELECTRICALENGINEER_VALUE:
			return ELECTRICALENGINEER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case MANUFACTURER_VALUE:
			return MANUFACTURER;
		case SUPPLIER_VALUE:
			return SUPPLIER;
		case STRUCTURALENGINEER_VALUE:
			return STRUCTURALENGINEER;
		case CLIENT_VALUE:
			return CLIENT;
		case OWNER_VALUE:
			return OWNER;
		case RESELLER_VALUE:
			return RESELLER;
		case CIVILENGINEER_VALUE:
			return CIVILENGINEER;
		case BUILDINGOPERATOR_VALUE:
			return BUILDINGOPERATOR;
		case PROJECTMANAGER_VALUE:
			return PROJECTMANAGER;
		case MECHANICALENGINEER_VALUE:
			return MECHANICALENGINEER;
		case FACILITIESMANAGER_VALUE:
			return FACILITIESMANAGER;
		case SUBCONTRACTOR_VALUE:
			return SUBCONTRACTOR;
		case FIELDCONSTRUCTIONMANAGER_VALUE:
			return FIELDCONSTRUCTIONMANAGER;
		case ARCHITECT_VALUE:
			return ARCHITECT;
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
	private IfcRoleEnum(int value, String name, String literal) {
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

} //IfcRoleEnum
