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
	 * The '<em><b>COSTENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSTENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	COSTENGINEER(1, "COSTENGINEER", "COSTENGINEER"),

	/**
	 * The '<em><b>COMISSIONINGENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMISSIONINGENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	COMISSIONINGENGINEER(2, "COMISSIONINGENGINEER", "COMISSIONINGENGINEER"),

	/**
	 * The '<em><b>BUILDINGOPERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOPERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	BUILDINGOPERATOR(3, "BUILDINGOPERATOR", "BUILDINGOPERATOR"),

	/**
	 * The '<em><b>RESELLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESELLER_VALUE
	 * @generated
	 * @ordered
	 */
	RESELLER(4, "RESELLER", "RESELLER"),

	/**
	 * The '<em><b>ENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	ENGINEER(5, "ENGINEER", "ENGINEER"),

	/**
	 * The '<em><b>ARCHITECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHITECT_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHITECT(6, "ARCHITECT", "ARCHITECT"),

	/**
	 * The '<em><b>PROJECTMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECTMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	PROJECTMANAGER(7, "PROJECTMANAGER", "PROJECTMANAGER"), /**
															 * The '<em><b>CLIENT</b></em>' literal object.
															 * <!-- begin-user-doc -->
															 * <!-- end-user-doc -->
															 * @see #CLIENT_VALUE
															 * @generated
															 * @ordered
															 */
	CLIENT(8, "CLIENT", "CLIENT"), /**
									 * The '<em><b>ELECTRICALENGINEER</b></em>' literal object.
									 * <!-- begin-user-doc -->
									 * <!-- end-user-doc -->
									 * @see #ELECTRICALENGINEER_VALUE
									 * @generated
									 * @ordered
									 */
	ELECTRICALENGINEER(9, "ELECTRICALENGINEER", "ELECTRICALENGINEER"),

	/**
	 * The '<em><b>CIVILENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIVILENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	CIVILENGINEER(10, "CIVILENGINEER", "CIVILENGINEER"),

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
	 * The '<em><b>CONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRACTOR(12, "CONTRACTOR", "CONTRACTOR"),

	/**
	 * The '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELDCONSTRUCTIONMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	FIELDCONSTRUCTIONMANAGER(13, "FIELDCONSTRUCTIONMANAGER", "FIELDCONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>FACILITIESMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACILITIESMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	FACILITIESMANAGER(14, "FACILITIESMANAGER", "FACILITIESMANAGER"),

	/**
	 * The '<em><b>OWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNER_VALUE
	 * @generated
	 * @ordered
	 */
	OWNER(15, "OWNER", "OWNER"),

	/**
	 * The '<em><b>CONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTIONMANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTRUCTIONMANAGER(16, "CONSTRUCTIONMANAGER", "CONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>STRUCTURALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURALENGINEER(17, "STRUCTURALENGINEER", "STRUCTURALENGINEER"),

	/**
	 * The '<em><b>MECHANICALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICALENGINEER_VALUE
	 * @generated
	 * @ordered
	 */
	MECHANICALENGINEER(18, "MECHANICALENGINEER", "MECHANICALENGINEER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(19, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>CONSULTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSULTANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSULTANT(20, "CONSULTANT", "CONSULTANT"),

	/**
	 * The '<em><b>MANUFACTURER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURER_VALUE
	 * @generated
	 * @ordered
	 */
	MANUFACTURER(21, "MANUFACTURER", "MANUFACTURER"),

	/**
	 * The '<em><b>SUBCONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBCONTRACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	SUBCONTRACTOR(22, "SUBCONTRACTOR", "SUBCONTRACTOR"),

	/**
	 * The '<em><b>BUILDINGOWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOWNER_VALUE
	 * @generated
	 * @ordered
	 */
	BUILDINGOWNER(23, "BUILDINGOWNER", "BUILDINGOWNER");

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
	public static final int COSTENGINEER_VALUE = 1;

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
	public static final int COMISSIONINGENGINEER_VALUE = 2;

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
	public static final int BUILDINGOPERATOR_VALUE = 3;

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
	public static final int RESELLER_VALUE = 4;

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
	public static final int ENGINEER_VALUE = 5;

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
	public static final int ARCHITECT_VALUE = 6;

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
	public static final int PROJECTMANAGER_VALUE = 7;

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
	public static final int CLIENT_VALUE = 8;

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
	public static final int ELECTRICALENGINEER_VALUE = 9;

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
	public static final int CIVILENGINEER_VALUE = 10;

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
	public static final int CONTRACTOR_VALUE = 12;

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
	public static final int FIELDCONSTRUCTIONMANAGER_VALUE = 13;

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
	public static final int FACILITIESMANAGER_VALUE = 14;

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
	public static final int OWNER_VALUE = 15;

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
	public static final int CONSTRUCTIONMANAGER_VALUE = 16;

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
	public static final int STRUCTURALENGINEER_VALUE = 17;

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
	public static final int MECHANICALENGINEER_VALUE = 18;

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
	public static final int USERDEFINED_VALUE = 19;

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
	public static final int CONSULTANT_VALUE = 20;

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
	public static final int MANUFACTURER_VALUE = 21;

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
	public static final int SUBCONTRACTOR_VALUE = 22;

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
	public static final int BUILDINGOWNER_VALUE = 23;

	/**
	 * An array of all the '<em><b>Ifc Role Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoleEnum[] VALUES_ARRAY = new IfcRoleEnum[] { NULL, COSTENGINEER, COMISSIONINGENGINEER, BUILDINGOPERATOR, RESELLER, ENGINEER, ARCHITECT,
			PROJECTMANAGER, CLIENT, ELECTRICALENGINEER, CIVILENGINEER, SUPPLIER, CONTRACTOR, FIELDCONSTRUCTIONMANAGER, FACILITIESMANAGER, OWNER, CONSTRUCTIONMANAGER,
			STRUCTURALENGINEER, MECHANICALENGINEER, USERDEFINED, CONSULTANT, MANUFACTURER, SUBCONTRACTOR, BUILDINGOWNER, };

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
	 * @generated
	 */
	public static IfcRoleEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case COSTENGINEER_VALUE:
			return COSTENGINEER;
		case COMISSIONINGENGINEER_VALUE:
			return COMISSIONINGENGINEER;
		case BUILDINGOPERATOR_VALUE:
			return BUILDINGOPERATOR;
		case RESELLER_VALUE:
			return RESELLER;
		case ENGINEER_VALUE:
			return ENGINEER;
		case ARCHITECT_VALUE:
			return ARCHITECT;
		case PROJECTMANAGER_VALUE:
			return PROJECTMANAGER;
		case CLIENT_VALUE:
			return CLIENT;
		case ELECTRICALENGINEER_VALUE:
			return ELECTRICALENGINEER;
		case CIVILENGINEER_VALUE:
			return CIVILENGINEER;
		case SUPPLIER_VALUE:
			return SUPPLIER;
		case CONTRACTOR_VALUE:
			return CONTRACTOR;
		case FIELDCONSTRUCTIONMANAGER_VALUE:
			return FIELDCONSTRUCTIONMANAGER;
		case FACILITIESMANAGER_VALUE:
			return FACILITIESMANAGER;
		case OWNER_VALUE:
			return OWNER;
		case CONSTRUCTIONMANAGER_VALUE:
			return CONSTRUCTIONMANAGER;
		case STRUCTURALENGINEER_VALUE:
			return STRUCTURALENGINEER;
		case MECHANICALENGINEER_VALUE:
			return MECHANICALENGINEER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case CONSULTANT_VALUE:
			return CONSULTANT;
		case MANUFACTURER_VALUE:
			return MANUFACTURER;
		case SUBCONTRACTOR_VALUE:
			return SUBCONTRACTOR;
		case BUILDINGOWNER_VALUE:
			return BUILDINGOWNER;
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
