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
 * A representation of the literals of the enumeration '<em><b>Ifc Role Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoleEnum()
 * @model
 * @generated
 */
public enum IfcRoleEnum implements Enumerator
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
	 * The '<em><b>COSTENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSTENGINEER
	 * @generated
	 * @ordered
	 */
	COSTENGINEER_LITERAL(1, "COSTENGINEER", "COSTENGINEER"),

	/**
	 * The '<em><b>COMISSIONINGENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMISSIONINGENGINEER
	 * @generated
	 * @ordered
	 */
	COMISSIONINGENGINEER_LITERAL(2, "COMISSIONINGENGINEER", "COMISSIONINGENGINEER"),

	/**
	 * The '<em><b>BUILDINGOPERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOPERATOR
	 * @generated
	 * @ordered
	 */
	BUILDINGOPERATOR_LITERAL(3, "BUILDINGOPERATOR", "BUILDINGOPERATOR"),

	/**
	 * The '<em><b>RESELLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESELLER
	 * @generated
	 * @ordered
	 */
	RESELLER_LITERAL(4, "RESELLER", "RESELLER"),

	/**
	 * The '<em><b>ENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENGINEER
	 * @generated
	 * @ordered
	 */
	ENGINEER_LITERAL(5, "ENGINEER", "ENGINEER"),

	/**
	 * The '<em><b>ARCHITECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHITECT
	 * @generated
	 * @ordered
	 */
	ARCHITECT_LITERAL(6, "ARCHITECT", "ARCHITECT"),

	/**
	 * The '<em><b>CLIENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLIENT
	 * @generated
	 * @ordered
	 */
	CLIENT_LITERAL(7, "CLIENT", "CLIENT"),

	/**
	 * The '<em><b>ELECTRICALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICALENGINEER
	 * @generated
	 * @ordered
	 */
	ELECTRICALENGINEER_LITERAL(8, "ELECTRICALENGINEER", "ELECTRICALENGINEER"),

	/**
	 * The '<em><b>PROJECTMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECTMANAGER
	 * @generated
	 * @ordered
	 */
	PROJECTMANAGER_LITERAL(9, "PROJECTMANAGER", "PROJECTMANAGER"),

	/**
	 * The '<em><b>CIVILENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIVILENGINEER
	 * @generated
	 * @ordered
	 */
	CIVILENGINEER_LITERAL(10, "CIVILENGINEER", "CIVILENGINEER"),

	/**
	 * The '<em><b>SUPPLIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPPLIER
	 * @generated
	 * @ordered
	 */
	SUPPLIER_LITERAL(11, "SUPPLIER", "SUPPLIER"),

	/**
	 * The '<em><b>CONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRACTOR
	 * @generated
	 * @ordered
	 */
	CONTRACTOR_LITERAL(12, "CONTRACTOR", "CONTRACTOR"),

	/**
	 * The '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELDCONSTRUCTIONMANAGER
	 * @generated
	 * @ordered
	 */
	FIELDCONSTRUCTIONMANAGER_LITERAL(13, "FIELDCONSTRUCTIONMANAGER", "FIELDCONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>FACILITIESMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACILITIESMANAGER
	 * @generated
	 * @ordered
	 */
	FACILITIESMANAGER_LITERAL(14, "FACILITIESMANAGER", "FACILITIESMANAGER"),

	/**
	 * The '<em><b>OWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNER
	 * @generated
	 * @ordered
	 */
	OWNER_LITERAL(15, "OWNER", "OWNER"),

	/**
	 * The '<em><b>CONSTRUCTIONMANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTIONMANAGER
	 * @generated
	 * @ordered
	 */
	CONSTRUCTIONMANAGER_LITERAL(16, "CONSTRUCTIONMANAGER", "CONSTRUCTIONMANAGER"),

	/**
	 * The '<em><b>STRUCTURALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALENGINEER
	 * @generated
	 * @ordered
	 */
	STRUCTURALENGINEER_LITERAL(17, "STRUCTURALENGINEER", "STRUCTURALENGINEER"),

	/**
	 * The '<em><b>MECHANICALENGINEER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICALENGINEER
	 * @generated
	 * @ordered
	 */
	MECHANICALENGINEER_LITERAL(18, "MECHANICALENGINEER", "MECHANICALENGINEER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(19, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>CONSULTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSULTANT
	 * @generated
	 * @ordered
	 */
	CONSULTANT_LITERAL(20, "CONSULTANT", "CONSULTANT"),

	/**
	 * The '<em><b>MANUFACTURER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURER
	 * @generated
	 * @ordered
	 */
	MANUFACTURER_LITERAL(21, "MANUFACTURER", "MANUFACTURER"),

	/**
	 * The '<em><b>SUBCONTRACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBCONTRACTOR
	 * @generated
	 * @ordered
	 */
	SUBCONTRACTOR_LITERAL(22, "SUBCONTRACTOR", "SUBCONTRACTOR"),

	/**
	 * The '<em><b>BUILDINGOWNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOWNER
	 * @generated
	 * @ordered
	 */
	BUILDINGOWNER_LITERAL(23, "BUILDINGOWNER", "BUILDINGOWNER");

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
	 * The '<em><b>COSTENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COSTENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COSTENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COSTENGINEER = 1;

	/**
	 * The '<em><b>COMISSIONINGENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMISSIONINGENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMISSIONINGENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMISSIONINGENGINEER = 2;

	/**
	 * The '<em><b>BUILDINGOPERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILDINGOPERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOPERATOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUILDINGOPERATOR = 3;

	/**
	 * The '<em><b>RESELLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESELLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESELLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESELLER = 4;

	/**
	 * The '<em><b>ENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENGINEER = 5;

	/**
	 * The '<em><b>ARCHITECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARCHITECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARCHITECT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCHITECT = 6;

	/**
	 * The '<em><b>CLIENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLIENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT = 7;

	/**
	 * The '<em><b>ELECTRICALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICALENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICALENGINEER = 8;

	/**
	 * The '<em><b>PROJECTMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROJECTMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECTMANAGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROJECTMANAGER = 9;

	/**
	 * The '<em><b>CIVILENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CIVILENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIVILENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIVILENGINEER = 10;

	/**
	 * The '<em><b>SUPPLIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUPPLIER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUPPLIER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPPLIER = 11;

	/**
	 * The '<em><b>CONTRACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTRACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTRACTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTRACTOR = 12;

	/**
	 * The '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIELDCONSTRUCTIONMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIELDCONSTRUCTIONMANAGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIELDCONSTRUCTIONMANAGER = 13;

	/**
	 * The '<em><b>FACILITIESMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FACILITIESMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACILITIESMANAGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FACILITIESMANAGER = 14;

	/**
	 * The '<em><b>OWNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OWNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OWNER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OWNER = 15;

	/**
	 * The '<em><b>CONSTRUCTIONMANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTRUCTIONMANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTIONMANAGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRUCTIONMANAGER = 16;

	/**
	 * The '<em><b>STRUCTURALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRUCTURALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURALENGINEER = 17;

	/**
	 * The '<em><b>MECHANICALENGINEER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MECHANICALENGINEER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MECHANICALENGINEER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MECHANICALENGINEER = 18;

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
	public static final int USERDEFINED = 19;

	/**
	 * The '<em><b>CONSULTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSULTANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSULTANT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSULTANT = 20;

	/**
	 * The '<em><b>MANUFACTURER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANUFACTURER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANUFACTURER = 21;

	/**
	 * The '<em><b>SUBCONTRACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBCONTRACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBCONTRACTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBCONTRACTOR = 22;

	/**
	 * The '<em><b>BUILDINGOWNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILDINGOWNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILDINGOWNER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUILDINGOWNER = 23;

	/**
	 * An array of all the '<em><b>Ifc Role Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoleEnum[] VALUES_ARRAY =
		new IfcRoleEnum[]
		{
			NULL_LITERAL,
			COSTENGINEER_LITERAL,
			COMISSIONINGENGINEER_LITERAL,
			BUILDINGOPERATOR_LITERAL,
			RESELLER_LITERAL,
			ENGINEER_LITERAL,
			ARCHITECT_LITERAL,
			CLIENT_LITERAL,
			ELECTRICALENGINEER_LITERAL,
			PROJECTMANAGER_LITERAL,
			CIVILENGINEER_LITERAL,
			SUPPLIER_LITERAL,
			CONTRACTOR_LITERAL,
			FIELDCONSTRUCTIONMANAGER_LITERAL,
			FACILITIESMANAGER_LITERAL,
			OWNER_LITERAL,
			CONSTRUCTIONMANAGER_LITERAL,
			STRUCTURALENGINEER_LITERAL,
			MECHANICALENGINEER_LITERAL,
			USERDEFINED_LITERAL,
			CONSULTANT_LITERAL,
			MANUFACTURER_LITERAL,
			SUBCONTRACTOR_LITERAL,
			BUILDINGOWNER_LITERAL,
		};

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
	public static IfcRoleEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcRoleEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
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
	public static IfcRoleEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcRoleEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
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
	public static IfcRoleEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case COSTENGINEER: return COSTENGINEER_LITERAL;
			case COMISSIONINGENGINEER: return COMISSIONINGENGINEER_LITERAL;
			case BUILDINGOPERATOR: return BUILDINGOPERATOR_LITERAL;
			case RESELLER: return RESELLER_LITERAL;
			case ENGINEER: return ENGINEER_LITERAL;
			case ARCHITECT: return ARCHITECT_LITERAL;
			case CLIENT: return CLIENT_LITERAL;
			case ELECTRICALENGINEER: return ELECTRICALENGINEER_LITERAL;
			case PROJECTMANAGER: return PROJECTMANAGER_LITERAL;
			case CIVILENGINEER: return CIVILENGINEER_LITERAL;
			case SUPPLIER: return SUPPLIER_LITERAL;
			case CONTRACTOR: return CONTRACTOR_LITERAL;
			case FIELDCONSTRUCTIONMANAGER: return FIELDCONSTRUCTIONMANAGER_LITERAL;
			case FACILITIESMANAGER: return FACILITIESMANAGER_LITERAL;
			case OWNER: return OWNER_LITERAL;
			case CONSTRUCTIONMANAGER: return CONSTRUCTIONMANAGER_LITERAL;
			case STRUCTURALENGINEER: return STRUCTURALENGINEER_LITERAL;
			case MECHANICALENGINEER: return MECHANICALENGINEER_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case CONSULTANT: return CONSULTANT_LITERAL;
			case MANUFACTURER: return MANUFACTURER_LITERAL;
			case SUBCONTRACTOR: return SUBCONTRACTOR_LITERAL;
			case BUILDINGOWNER: return BUILDINGOWNER_LITERAL;
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
	private IfcRoleEnum(int value, String name, String literal)
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
	
} //IfcRoleEnum
